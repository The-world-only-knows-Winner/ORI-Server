package com.onlywin.ori.domain.auth.presentation

import com.onlywin.ori.domain.auth.presentation.dto.request.SendAuthCodeWebRequest
import com.onlywin.ori.domain.auth.presentation.dto.request.SignInWebRequest
import com.onlywin.ori.domain.auth.presentation.dto.request.VerifyAuthCodeWebRequest
import com.onlywin.ori.domain.auth.usecase.SendAuthCodeUseCase
import com.onlywin.ori.domain.auth.usecase.SignInUseCase
import com.onlywin.ori.domain.auth.usecase.VerifyAuthCodeUseCase
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthWebAdapter(
    private val sendAuthCodeUseCase: SendAuthCodeUseCase,
    private val verifyAuthCodeUseCase: VerifyAuthCodeUseCase,
    private val signInUseCase: SignInUseCase,
) {

    @PostMapping("/code")
    fun sendAuthCode(@RequestBody @Valid request: SendAuthCodeWebRequest) {
        sendAuthCodeUseCase.execute(request.toDomainRequest())
    }

    @PatchMapping("/code")
    fun verifyAuthCode(@RequestBody @Valid request: VerifyAuthCodeWebRequest) {
        verifyAuthCodeUseCase.execute(request.toDomainRequest())
    }

    @PostMapping("/token")
    fun signIn(@RequestBody request: SignInWebRequest) {
        signInUseCase.execute(request.toDomainRequest())
    }
}
