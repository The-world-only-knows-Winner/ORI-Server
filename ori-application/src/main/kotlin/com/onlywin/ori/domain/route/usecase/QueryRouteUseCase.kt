package com.onlywin.ori.domain.route.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.domain.route.dto.response.QueryRouteList
import com.onlywin.ori.domain.route.spi.QueryRoutePort

@UseCase
class QueryRouteUseCase(
    private val queryRoutePort: QueryRoutePort,
) {

    fun execute(
        startXPoint: Float,
        startYPoint: Float,
        endXPoint: Float,
        endYPoint: Float,
    ) = QueryRouteList(
        queryRoutePort.queryPublicTransitRouteByPoint(
            startXPoint = startXPoint,
            startYPoint = startYPoint,
            endXPoint = endXPoint,
            endYPoint = endYPoint,
        ),
    )
}
