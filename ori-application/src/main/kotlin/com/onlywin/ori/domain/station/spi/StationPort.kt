package com.onlywin.ori.domain.station.spi

import com.onlywin.ori.domain.station.Station
import com.onlywin.ori.domain.station.dto.response.QueryStationList.StationElement
import com.onlywin.ori.domain.station.spi.vo.RouteStationListVO
import java.util.UUID

interface StationPort : CommandStationPort, QueryStationPort

interface CommandStationPort {
    fun saveAllStation(stationList: List<Station>)
}

interface QueryStationPort {
    fun queryStationByStationName(stationName: String): List<StationElement>
    fun queryStationByRouteId(routeId: UUID): List<RouteStationListVO>
}
