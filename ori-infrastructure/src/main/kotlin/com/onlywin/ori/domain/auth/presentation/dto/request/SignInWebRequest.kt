package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.request.SignInRequest

data class SignInWebRequest(
    val email: String,
    val password: String,
) {
    fun toDomainRequest() = SignInRequest(
        email = email,
        password = password,
    )
}
