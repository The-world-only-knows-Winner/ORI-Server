package com.onlywin.ori.station

import com.onlywin.ori.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class Station(
    val id: UUID,
    val busNumber: String,
    val stationName: String,
    val index: Int,
    val time: Int = 0,
    val routeId: UUID,
)
