package com.onlywin.ori.route.domain

import com.onlywin.ori.common.entity.BaseUUIDEntity
import com.onlywin.ori.domain.user.persistence.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "tbl_route")
class RouteEntity(
    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val startXPoint: Float,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val startYPoint: Float,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val endXPoint: Float,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val endYPoint: Float,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val time: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,
) : BaseUUIDEntity(id)
