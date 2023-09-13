package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SendMailPort
import com.onlywin.ori.domain.auth.dto.request.SendAuthCodeRequest
import com.onlywin.ori.domain.auth.AuthCode
import com.onlywin.ori.domain.auth.spi.CommendAuthCodePort

@UseCase
class SendAuthCodeUseCase(
    private val commendAuthCodePort: CommendAuthCodePort,
    private val sendMailPort: SendMailPort,
) {

    fun execute(request: SendAuthCodeRequest) {
        val code = (Math.random() * 899999).toInt().toString()

        commendAuthCodePort.saveAuthCode(
            AuthCode(
                id = request.email,
                code = code,
                verified = false,
                ttl = 300L,
            )
        )

        sendMailPort.sendMail(
            "오리 메일 인증",
            "오리 메일 인증 코드입니다.\n $code",
            request.email
        )
    }
}
