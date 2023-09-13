package com.onlywin.ori.domain.user.presentation

import com.onlywin.ori.domain.user.presentation.dto.request.SignUpWebRequest
import com.onlywin.ori.domain.user.usecase.SignUpUseCase
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserWebAdapter(
    private val signUpUseCase: SignUpUseCase,
) {

    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpWebRequest) =
        signUpUseCase.execute(request.toDomainRequest())
}