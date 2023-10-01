package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.domain.auth.dto.response.TokenResponse
import com.onlywin.ori.domain.auth.exception.RefreshTokenNotFoundException
import com.onlywin.ori.domain.auth.spi.CommandRefreshTokenPort
import com.onlywin.ori.domain.auth.spi.JwtPort
import com.onlywin.ori.domain.auth.spi.QueryRefreshTokenPort

@UseCase
class TokenRefreshUseCase(
    private val jwtPort: JwtPort,
    private val commandRefreshTokenPort: CommandRefreshTokenPort,
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
) {

    fun execute(refreshToken: String): TokenResponse {
        val redisRefreshToken = queryRefreshTokenPort.queryRefreshTokenByRefreshToken(refreshToken)
            ?: throw RefreshTokenNotFoundException

        commandRefreshTokenPort.deleteRefreshToken(redisRefreshToken)

        return jwtPort.generateTokens(redisRefreshToken.id)
    }
}
