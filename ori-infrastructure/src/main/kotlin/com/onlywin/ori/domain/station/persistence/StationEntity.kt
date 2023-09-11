package com.onlywin.ori.domain.station.persistence

import com.onlywin.ori.common.entity.BaseUUIDEntity
import com.onlywin.ori.domain.route.persistence.RouteEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "tbl_station")
class StationEntity(
    override val id: UUID,

    @Column(columnDefinition = "VARCHAR(10)")
    val busNumber: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val stationName: String,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val index: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val time: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    val route: RouteEntity,
) : BaseUUIDEntity(id)
