package com.onlywin.ori.domain.route.spi

import com.onlywin.ori.domain.route.Route
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.RouteElement
import java.util.UUID

interface RoutePort : CommendRoutePort, QueryRoutePort

interface CommendRoutePort {
    fun saveRouteAndGetId(route: Route): UUID
}

interface QueryRoutePort {
    fun queryPublicTransitRouteByPoint(startXPoint: Float, startYPoint: Float, endXPoint: Float, endYPoint: Float): RouteElement
}
