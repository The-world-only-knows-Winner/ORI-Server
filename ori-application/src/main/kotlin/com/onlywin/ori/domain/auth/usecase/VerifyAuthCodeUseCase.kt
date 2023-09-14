package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.domain.auth.dto.request.VerifyAuthCodeRequest
import com.onlywin.ori.domain.auth.exception.AuthCodeNotFoundException
import com.onlywin.ori.domain.auth.spi.CommendAuthCodePort
import com.onlywin.ori.domain.auth.spi.QueryAuthCodePort

@UseCase
class VerifyAuthCodeUseCase(
    private val queryAuthCodePort: QueryAuthCodePort,
    private val commendAuthCodePort: CommendAuthCodePort,
) {

    fun execute(request: VerifyAuthCodeRequest) {
        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw AuthCodeNotFoundException

        commendAuthCodePort.saveAuthCode(
            authCode.verifyAuthCode(request.code),
        )
    }
}
