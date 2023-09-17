package com.onlywin.ori.domain.station.dto.response

data class QueryStationList(
    val stationList: List<StationElement>,
) {
    data class StationElement(
        val stationName: String,
        val stationId: Int,
        val pointX: Float,
        val pointY: Float,
        val busInfo: List<BusInfo>,
    )

    data class BusInfo(
        val busLocalId: String,
        val busNo: String,
    )
}
