package com.onlywin.ori.thirdparty.feign.client.route

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.onlywin.ori.common.util.findValueByFieldName
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.Path
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.PathInfo
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.RouteElement
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.SubPath
import com.onlywin.ori.domain.route.enums.TrafficType
import com.onlywin.ori.domain.route.spi.RoutePort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
class RouteClientImpl(
    @Value("\${api.key}")
    private val apiKey: String,
    private val routeClient: RouteClient,
) : RoutePort {

    companion object {
        const val RESULT = "result"
        const val BUS_COUNT = "busCount"
        const val PATH = "path"
        const val PATH_INFO = "info"
        const val TOTAL_TIME = "totalTime"
        const val BUS_TRANSIT_COUNT = "busTransitCount"
        const val FIRST_START_STATION = "firstStartStation"
        const val LAST_END_STATION = "lastEndStation"
        const val SUB_PATH_LIST = "subPath"
        const val TRAFFIC_TYPE = "trafficType"
        const val SECTION_TIME = "sectionTime"
        const val BUS_NO = "busNo"
        const val START_NAME = "startName"
        const val START_X_POINT = "startX"
        const val START_Y_POINT = "startY"
        const val END_NAME = "endName"
        const val END_X_POINT = "endX"
        const val END_Y_POINT = "endY"
    }

    override fun queryPublicTransitRouteByPoint(
        startXPoint: Float,
        startYPoint: Float,
        endXPoint: Float,
        endYPoint: Float,
    ): RouteElement {
        val routeInfo = routeClient.getPublicTransitRoute(
            apiKey = URLEncoder.encode(apiKey, "UTF-8"),
            startXPoint = startXPoint,
            startYPoint = startYPoint,
            endXPoint = endXPoint,
            endYPoint = endYPoint,
            searchPathType = 2,
        )

        return dataParsing(routeInfo)
    }

    private fun dataParsing(routeInfo: String): RouteElement =
        jacksonObjectMapper().readValue<JsonNode>(routeInfo)
            .findValue(RESULT)
            .getRoute()

    private fun JsonNode.getRoute() = RouteElement(
        busCount = this.findValueByFieldName(BUS_COUNT).toInt(),
        pathList = this.findValue(PATH).map { it.getPath() },
    )

    private fun JsonNode.getPath() = Path(
        pathInfo = this.findValue(PATH_INFO).getPathInfo(),
        subPathList = this.findValue(SUB_PATH_LIST).map { it.getSubPathList() },
    )

    private fun JsonNode.getSubPathList() = SubPath(
        trafficType = this.findValueByFieldName(TRAFFIC_TYPE).toInt().let {
            when (it) {
                1 -> TrafficType.SUBWAY
                2 -> TrafficType.BUS
                else -> TrafficType.WALKING
            }
        },
        sectionTime = this.findValueByFieldName(SECTION_TIME).toInt(),
        busNo = this.findValueByFieldName(BUS_NO),
        startName = this.findValueByFieldName(START_NAME),
        startXPoint = this.findValueByFieldName(START_X_POINT).ifEmpty { "0" }.toFloat(),
        startYPoint = this.findValueByFieldName(START_Y_POINT).ifEmpty { "0" }.toFloat(),
        endName = this.findValueByFieldName(END_NAME),
        endXPoint = this.findValueByFieldName(END_X_POINT).ifEmpty { "0" }.toFloat(),
        endYPoint = this.findValueByFieldName(END_Y_POINT).ifEmpty { "0" }.toFloat(),
    )

    private fun JsonNode.getPathInfo() = PathInfo(
        totalTime = this.findValueByFieldName(TOTAL_TIME).toInt(),
        busTransitCount = this.findValueByFieldName(BUS_TRANSIT_COUNT).toInt(),
        firstStartStation = this.findValueByFieldName(FIRST_START_STATION),
        lastEndStation = this.findValueByFieldName(LAST_END_STATION),
    )
}
