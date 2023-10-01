package com.onlywin.ori.domain.route.dto.request

data class AddRouteRequest(
    val startXPoint: Float,
    val startYPoint: Float,
    val endXPoint: Float,
    val endYPoint: Float,
    val totalTime: Int,
    val subRouteList: List<SubRouteRequest>,
) {
    data class SubRouteRequest(
        val busNumber: String,
        val stationName: String,
        val index: Int,
        val sectionTime: Int,
    )
}
