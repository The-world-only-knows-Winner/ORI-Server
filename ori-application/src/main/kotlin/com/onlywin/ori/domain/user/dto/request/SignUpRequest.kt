package com.onlywin.ori.domain.user.dto.request

import java.time.LocalDate

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val birthday: LocalDate,
)
