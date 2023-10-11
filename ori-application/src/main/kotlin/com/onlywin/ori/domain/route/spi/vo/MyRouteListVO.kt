package com.onlywin.ori.domain.route.spi.vo

import java.util.UUID

open class MyRouteListVO(
    val routeId: UUID,
    val startName: String,
    val startXPoint: Float,
    val startYPoint: Float,
    val endName: String,
    val endXPoint: Float,
    val endYPoint: Float,
    val time: Int,
)
