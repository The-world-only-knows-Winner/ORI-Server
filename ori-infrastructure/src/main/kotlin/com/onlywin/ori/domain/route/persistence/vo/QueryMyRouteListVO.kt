package com.onlywin.ori.domain.route.persistence.vo

import com.onlywin.ori.domain.route.spi.vo.MyRouteListVO
import com.querydsl.core.annotations.QueryProjection

class QueryMyRouteListVO @QueryProjection constructor(
    startName: String,
    startXPoint: Float,
    startYPoint: Float,
    endName: String,
    endXPoint: Float,
    endYPoint: Float,
    time: Int,
) : MyRouteListVO(
    startName = startName,
    startXPoint = startXPoint,
    startYPoint = startYPoint,
    endName = endName,
    endXPoint = endXPoint,
    endYPoint = endYPoint,
    time = time,
)
