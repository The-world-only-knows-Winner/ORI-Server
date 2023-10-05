package com.onlywin.ori.domain.station.dto.response

import com.onlywin.ori.domain.station.spi.vo.RouteStationListVO

data class QueryRouteStationListResponse(
    val stationList: List<RouteStationListVO>
)