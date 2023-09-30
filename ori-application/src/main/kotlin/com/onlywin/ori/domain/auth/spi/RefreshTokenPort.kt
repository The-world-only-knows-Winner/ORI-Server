package com.onlywin.ori.domain.auth.spi

import com.onlywin.ori.domain.auth.RefreshToken
import java.util.UUID

interface RefreshTokenPort : CommandRefreshTokenPort, QueryRefreshTokenPort

interface CommandRefreshTokenPort {
    fun deleteRefreshToken(refreshToken: RefreshToken)
}

interface QueryRefreshTokenPort {
    fun queryRefreshTokenByUserId(userId: UUID): RefreshToken
}
