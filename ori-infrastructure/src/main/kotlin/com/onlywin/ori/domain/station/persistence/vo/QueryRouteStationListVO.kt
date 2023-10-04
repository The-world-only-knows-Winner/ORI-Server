package com.onlywin.ori.domain.station.persistence.vo

import com.onlywin.ori.domain.station.spi.vo.RouteStationListVO
import com.querydsl.core.annotations.QueryProjection

class QueryRouteStationListVO @QueryProjection constructor(
    busNumber: String,
    stationName: String,
    index: Int,
    time: Int,
): RouteStationListVO(
    busNumber = busNumber,
    stationName = stationName,
    index = index,
    time = time,
)