package com.onlywin.ori.domain.station.persistence

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.common.util.findValueByFieldName
import com.onlywin.ori.domain.route.persistence.QRouteEntity.routeEntity
import com.onlywin.ori.domain.station.Station
import com.onlywin.ori.domain.station.dto.response.QueryStationList.StationElement
import com.onlywin.ori.domain.station.dto.response.QueryStationList.BusInfo
import com.onlywin.ori.domain.station.persistence.QStationEntity.stationEntity
import com.onlywin.ori.domain.station.persistence.vo.QQueryRouteStationListVO
import com.onlywin.ori.domain.station.persistence.vo.QueryRouteStationListVO
import com.onlywin.ori.domain.station.spi.StationPort
import com.onlywin.ori.thirdparty.feign.client.station.StationClient
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Value
import java.net.URLEncoder
import java.util.UUID

@Adapter
class StationPersistenceAdapter(
    @Value("\${api.key}")
    private val apiKey: String,
    private val stationClient: StationClient,
    private val stationRepository: StationRepository,
    private val stationMapper: StationMapper,
    private val queryFactory: JPAQueryFactory,
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

    override fun saveAllStation(stationList: List<Station>) {
        stationRepository.saveAll(stationList.map(stationMapper::stationDomainToEntity))
    }

    override fun queryStationByStationName(stationName: String): List<StationElement> {
        val stationInfo = stationClient.getStationByStationName(
            apiKey = URLEncoder.encode(apiKey, "UTF-8"),
            stationName = stationName,
        )
        return dataParsing(stationInfo)
    }

    override fun queryStationByRouteId(routeId: UUID): List<QueryRouteStationListVO> =
        queryFactory
            .select(
                QQueryRouteStationListVO(
                    stationEntity.busNumber,
                    stationEntity.stationName,
                    stationEntity.index,
                    stationEntity.time,
                )
            )
            .from(stationEntity)
            .join(stationEntity.route, routeEntity)
            .where(routeEntity.id.eq(routeId))
            .orderBy(stationEntity.index.asc())
            .fetch()

    private fun dataParsing(stationInfo: String): List<StationElement> =
        jacksonObjectMapper().readValue<JsonNode>(stationInfo)
            .findValue(RESULT)
            .findValue(STATION)
            .map { it.getStation() }

    private fun JsonNode.getStation() = StationElement(
        stationName = this.findValueByFieldName(STATION_NAME),
        stationId = this.findValueByFieldName(STATION_ID).toInt(),
        pointX = this.findValueByFieldName(POINT_X).toFloat(),
        pointY = this.findValueByFieldName(POINT_Y).toFloat(),
        busInfo = this.findValue(BUS_INFO).map { it.getBusInfo() },
    )

    private fun JsonNode.getBusInfo() = BusInfo(
        busLocalId = this.findValueByFieldName(BUS_ID),
        busNo = this.findValueByFieldName(BUS_NUMBER),
    )
}
