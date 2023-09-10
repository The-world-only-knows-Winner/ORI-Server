package com.onlywin.ori.domain.user.model

import com.onlywin.ori.common.annotation.Aggregate
import java.time.LocalDate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,
    val birthday: LocalDate,
    val deviceToken: String,
)
