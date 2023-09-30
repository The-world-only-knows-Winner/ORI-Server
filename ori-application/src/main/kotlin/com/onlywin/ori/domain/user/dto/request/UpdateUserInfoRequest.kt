package com.onlywin.ori.domain.user.dto.request

import java.time.LocalDate

data class UpdateUserInfoRequest(
    val name: String,
    val birthday: LocalDate,
)
