package com.onlywin.ori.domain.user.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.auth.exception.AuthCodeNotFoundException
import com.onlywin.ori.domain.auth.exception.UnverifiedEmailException
import com.onlywin.ori.domain.auth.spi.QueryAuthCodePort
import com.onlywin.ori.domain.user.User
import com.onlywin.ori.domain.user.dto.request.SignUpRequest
import com.onlywin.ori.domain.user.exception.UserAlreadyExistsException
import com.onlywin.ori.domain.user.spi.CommandUserPort
import com.onlywin.ori.domain.user.spi.QueryUserPort

@UseCase
class SignUpUseCase(
    private val commendUserPort: CommandUserPort,
    private val queryUserPort: QueryUserPort,
    private val queryAuthCodePort: QueryAuthCodePort,
    private val securityPort: SecurityPort,
) {

    fun execute(request: SignUpRequest) {
        if (queryUserPort.existsUserByEmail(request.email)) {
            throw UserAlreadyExistsException
        }

        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw AuthCodeNotFoundException

        if (!authCode.verified) {
            throw UnverifiedEmailException
        }

        commendUserPort.saveUser(
            User(
                email = request.email,
                password = securityPort.encodePassword(request.password),
                name = request.name,
                birthday = request.birthday,
                deviceToken = request.deviceToken
            )
        )
    }
}