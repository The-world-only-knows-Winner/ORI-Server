package com.onlywin.ori.domain.user.presentation

import com.onlywin.ori.domain.user.dto.response.QueryMyInfoResponse
import com.onlywin.ori.domain.user.presentation.dto.request.SignUpWebRequest
import com.onlywin.ori.domain.user.presentation.dto.request.UpdateUserInfoWebRequest
import com.onlywin.ori.domain.user.usecase.QueryMyInfoUseCase
import com.onlywin.ori.domain.user.usecase.SignUpUseCase
import com.onlywin.ori.domain.user.usecase.UpdateUserInfoUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserWebAdapter(
    private val signUpUseCase: SignUpUseCase,
    private val updateUserInfoUseCase: UpdateUserInfoUseCase,
    private val queryMyInfoUseCase: QueryMyInfoUseCase,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(
        @RequestBody @Valid
        request: SignUpWebRequest,
    ) {
        signUpUseCase.execute(request.toDomainRequest())
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    fun updateUserInfo(
        @RequestBody @Valid
        request: UpdateUserInfoWebRequest,
    ) {
        updateUserInfoUseCase.execute(request.toDomainRequest())
    }

    @GetMapping
    fun getMyInfo(): QueryMyInfoResponse {
        return queryMyInfoUseCase.execute()
    }
}
