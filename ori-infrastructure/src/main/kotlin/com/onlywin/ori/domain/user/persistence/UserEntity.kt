package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.common.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.util.UUID

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
