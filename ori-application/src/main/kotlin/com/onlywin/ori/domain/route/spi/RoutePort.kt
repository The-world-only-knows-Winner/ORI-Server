package com.onlywin.ori.domain.route.spi

import com.onlywin.ori.domain.route.Route
import com.onlywin.ori.domain.route.dto.response.QueryRouteList.RouteElement
import com.onlywin.ori.domain.route.spi.vo.MyRouteListVO
import java.util.UUID

interface RoutePort : CommendRoutePort, QueryRoutePort

interface CommendRoutePort {
    fun saveRouteAndGetId(route: Route): UUID
}

interface QueryRoutePort {
    fun queryPublicTransitRouteByPoint(startXPoint: Float, startYPoint: Float, endXPoint: Float, endYPoint: Float): RouteElement
    fun queryRouteListByUserId(userId: UUID): List<MyRouteListVO>
}
