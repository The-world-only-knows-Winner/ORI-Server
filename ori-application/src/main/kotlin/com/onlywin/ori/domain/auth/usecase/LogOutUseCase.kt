package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.auth.spi.CommandRefreshTokenPort
import com.onlywin.ori.domain.auth.spi.QueryRefreshTokenPort

@UseCase
class LogOutUseCase(
    private val commandRefreshTokenPort: CommandRefreshTokenPort,
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val securityPort: SecurityPort,
) {

    fun execute() {
        val userId = securityPort.getCurrentUserId()
        queryRefreshTokenPort.queryRefreshTokenByUserId(userId)
            .run { commandRefreshTokenPort.deleteRefreshToken(this) }
    }
}
