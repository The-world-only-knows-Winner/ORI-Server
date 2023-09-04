package com.onlywin.ori.user.domain

import com.onlywin.ori.common.entity.BaseUUIDEntity
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class UserEntity(
    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(64)", unique = true)
    val email: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "DATE")
    val birthday: LocalDate,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    val deviceToken: String,
) : BaseUUIDEntity(id)
