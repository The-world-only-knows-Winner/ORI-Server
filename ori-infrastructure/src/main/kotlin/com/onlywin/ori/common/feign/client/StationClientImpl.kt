package com.onlywin.ori.common.feign.client

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.onlywin.ori.domain.station.dto.response.QueryStationList.BusInfo
import com.onlywin.ori.domain.station.dto.response.QueryStationList.StationElement
import com.onlywin.ori.domain.station.spi.StationPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
class StationClientImpl(
    @Value("\${api.key}")
    private val apiKey: String,
    private val stationClient: StationClient,
) : StationPort {

    companion object {
        const val RESULT = "result"
        const val STATION = "station"
        const val STATION_NAME = "stationName"
        const val STATION_ID = "stationID"
        const val POINT_X = "x"
        const val POINT_Y = "y"
        const val BUS_INFO = "businfo"
        const val BUS_ID = "busLocalBlID"
        const val BUS_NUMBER = "busNo"
    }

    override fun queryStationByStationName(stationName: String): List<StationElement> {
        val stationInfo = stationClient.getStationByStationName(
            apiKey = URLEncoder.encode(apiKey, "UTF-8"),
            stationName = stationName,
        )
        return dataParsing(stationInfo)
    }

    private fun dataParsing(stationInfo: String): List<StationElement> =
        jacksonObjectMapper().readValue<JsonNode>(stationInfo)
            .findValue(RESULT)
            .findValue(STATION)
            .map { station ->
                StationElement(
                    stationName = station.findValueByFieldName(STATION_NAME),
                    stationId = station.findValueByFieldName(STATION_ID).toInt(),
                    pointX = station.findValueByFieldName(POINT_X).toFloat(),
                    pointY = station.findValueByFieldName(POINT_Y).toFloat(),
                    busInfo = station.findValue(BUS_INFO).map { busInfo ->
                        BusInfo(
                            busLocalID = busInfo.findValueByFieldName(BUS_ID),
                            busNo = busInfo.findValueByFieldName(BUS_NUMBER),
                        )
                    }
                )
            }

    private fun JsonNode.findValueByFieldName(fieldName: String): String {
        return try {
            this.findValue(fieldName).asText()
        } catch (e: NullPointerException) {
            ""
        }
    }
}
