package com.onlywin.ori.domain.route.dto.request

data class AddRouteRequest(
    val startName: String,
    val startXPoint: Float,
    val startYPoint: Float,
    val endName: String,
    val endXPoint: Float,
    val endYPoint: Float,
    val totalTime: Int,
    val subStationList: List<SubStationRequest>,
) {
    data class SubStationRequest(
        val busNumber: String,
        val stationName: String,
        val index: Int,
        val sectionTime: Int,
    )
}
