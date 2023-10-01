package com.onlywin.ori.domain.route.presentation.dto.request

import com.onlywin.ori.domain.route.dto.request.AddRouteRequest
import com.onlywin.ori.domain.route.dto.request.AddRouteRequest.SubRouteRequest
import jakarta.validation.constraints.NotBlank

data class AddRouteWebRequest(
    val startXPoint: Float,
    val startYPoint: Float,
    val endXPoint: Float,
    val endYPoint: Float,
    val totalTime: Int,
    val subRouteList: List<SubRouteWebRequest>,
) {
    data class SubRouteWebRequest(
        @field:NotBlank
        val busNumber: String,
        @field:NotBlank
        val stationName: String,
        val index: Int,
        val sectionTime: Int,
    ) {
        fun toDomainRequest() = SubRouteRequest(
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
        subRouteList = subRouteList.map(SubRouteWebRequest::toDomainRequest),
    )
}
