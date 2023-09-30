package com.onlywin.ori.domain.user.dto.response

import java.time.LocalDate

data class QueryMyInfoResponse(
    val name: String,
    val birthday: LocalDate,
)
