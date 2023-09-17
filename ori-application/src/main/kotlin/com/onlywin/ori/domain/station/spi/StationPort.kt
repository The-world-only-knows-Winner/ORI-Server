package com.onlywin.ori.domain.station.spi

import com.onlywin.ori.domain.station.dto.response.QueryStationList.StationElement

interface StationPort : QueryStationPort

interface QueryStationPort {
    fun queryStationByStationName(stationName: String): List<StationElement>
}
