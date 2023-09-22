package com.onlywin.ori.domain.route.dto.response

import com.onlywin.ori.domain.route.enums.TrafficType

data class QueryRouteList(
    val routeList: RouteElement,
) {

    data class RouteElement(
        val busCount: Int,
        val pathList: List<Path>,
    )

    data class Path(
        val pathInfo: PathInfo,
        val subPathList: List<SubPath>,
    )

    data class PathInfo(
        val totalTime: Int,
        val busTransitCount: Int,
        val firstStartStation: String,
        val lastEndStation: String,
    )

    data class SubPath(
        val trafficType: TrafficType,
        val sectionTime: Int,
        val busNo: String?,
        val startName: String?,
        val startXPoint: Float?,
        val startYPoint: Float?,
        val endName: String?,
        val endXPoint: Float?,
        val endYPoint: Float?,
    )
}
