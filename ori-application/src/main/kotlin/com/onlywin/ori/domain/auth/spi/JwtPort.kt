package com.onlywin.ori.domain.auth.spi

import com.onlywin.ori.domain.auth.dto.response.TokenResponse
import java.util.UUID

interface JwtPort {
    fun generateTokens(id: UUID): TokenResponse
}
