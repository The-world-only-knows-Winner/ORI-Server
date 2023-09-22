package com.onlywin.ori.domain.route.spi

import com.onlywin.ori.domain.route.dto.response.QueryRouteList.RouteElement

interface RoutePort : CommendRoutePort, QueryRoutePort

interface CommendRoutePort

interface QueryRoutePort {
    fun queryPublicTransitRouteByPoint(startXPoint: Float, startYPoint: Float, endXPoint: Float, endYPoint: Float): RouteElement
}
