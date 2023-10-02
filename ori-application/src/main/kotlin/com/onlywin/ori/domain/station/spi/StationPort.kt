package com.onlywin.ori.domain.station.spi

import com.onlywin.ori.domain.station.Station
import com.onlywin.ori.domain.station.dto.response.QueryStationList.StationElement

interface StationPort : CommandStationPort, QueryStationPort

interface CommandStationPort {
    fun saveAllStation(stationList: List<Station>)
}

interface QueryStationPort {
    fun queryStationByStationName(stationName: String): List<StationElement>
}
