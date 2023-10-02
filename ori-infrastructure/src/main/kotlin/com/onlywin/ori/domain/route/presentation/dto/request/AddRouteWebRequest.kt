package com.onlywin.ori.domain.route.presentation.dto.request

import com.onlywin.ori.domain.route.dto.request.AddRouteRequest
import com.onlywin.ori.domain.route.dto.request.AddRouteRequest.SubStationRequest
import jakarta.validation.constraints.NotBlank

data class AddRouteWebRequest(
    val startXPoint: Float,
    val startYPoint: Float,
    val endXPoint: Float,
    val endYPoint: Float,
    val totalTime: Int,
    val subStationList: List<SubStationWebRequest>,
) {
    data class SubStationWebRequest(
        @field:NotBlank
        val busNumber: String,
        @field:NotBlank
        val stationName: String,
        val index: Int,
        val sectionTime: Int,
    ) {
        fun toDomainRequest() = SubStationRequest(
            busNumber = busNumber,
            stationName = stationName,
            index = index,
            sectionTime = sectionTime,
        )
    }

    fun toDomainRequest() = AddRouteRequest(
        startXPoint = startXPoint,
        startYPoint = startYPoint,
        endXPoint = endXPoint,
        endYPoint = endYPoint,
        totalTime = totalTime,
        subStationList = subStationList.map(SubStationWebRequest::toDomainRequest),
    )
}
