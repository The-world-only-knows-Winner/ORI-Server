package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.VerifyAuthCodeRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class VerifyAuthCodeWebRequest(

    @NotBlank
    @Email
    val email: String,

    @NotBlank
    @Size(min = 6, max = 6)
    val code: String,
) {
    fun toDomainRequest() = VerifyAuthCodeRequest(
        email = email,
        code = code
    )
}
