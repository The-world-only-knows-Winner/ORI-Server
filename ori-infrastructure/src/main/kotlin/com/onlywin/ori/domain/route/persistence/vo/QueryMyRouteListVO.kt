package com.onlywin.ori.domain.route.persistence.vo

import com.onlywin.ori.domain.route.spi.vo.MyRouteListVO
import com.querydsl.core.annotations.QueryProjection
import java.util.UUID

class QueryMyRouteListVO @QueryProjection constructor(
    routeId: UUID,
    startName: String,
    startXPoint: Float,
    startYPoint: Float,
    endName: String,
    endXPoint: Float,
    endYPoint: Float,
    time: Int,
) : MyRouteListVO(
    routeId = routeId,
    startName = startName,
    startXPoint = startXPoint,
    startYPoint = startYPoint,
    endName = endName,
    endXPoint = endXPoint,
    endYPoint = endYPoint,
    time = time,
)
