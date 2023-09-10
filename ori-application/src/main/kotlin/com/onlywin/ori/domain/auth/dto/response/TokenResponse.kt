package com.onlywin.ori.domain.auth.dto.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val accessExpiresAt: LocalDateTime,
    val refreshToken: String,
    val refreshExpiresAt: LocalDateTime,
)
