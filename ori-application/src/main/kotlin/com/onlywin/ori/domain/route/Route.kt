package com.onlywin.ori.domain.route

import com.onlywin.ori.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class Route(
    val id: UUID = UUID.randomUUID(),
    val startName: String,
    val startXPoint: Float,
    val startYPoint: Float,
    val endName: String,
    val endXPoint: Float,
    val endYPoint: Float,
    val time: Int,
    val userId: UUID,
)
