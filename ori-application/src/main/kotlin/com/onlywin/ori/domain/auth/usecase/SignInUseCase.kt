package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.auth.dto.request.SignInRequest
import com.onlywin.ori.domain.auth.dto.response.TokenResponse
import com.onlywin.ori.domain.auth.exception.EmailMisMatchException
import com.onlywin.ori.domain.auth.exception.PasswordMisMatchException
import com.onlywin.ori.domain.auth.spi.JwtPort
import com.onlywin.ori.domain.user.spi.QueryUserPort

@UseCase
class SignInUseCase(
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort,
    private val jwtPort: JwtPort,
) {
    fun execute(request: SignInRequest): TokenResponse {
        val user = queryUserPort.queryUserByEmail(request.email)
            ?: throw EmailMisMatchException

        checkPasswordMatches(request.password, user.password)

        return jwtPort.generateTokens(user.id)
    }

    private fun checkPasswordMatches(
        rawPassword: String,
        encodePassword: String,
    ) {
        val isPasswordMatches = securityPort.passwordMatches(rawPassword, encodePassword)
        if (!isPasswordMatches) {
            throw PasswordMisMatchException
        }
    }
}
