package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.request.VerifyAuthCodeRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class VerifyAuthCodeWebRequest(

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(min = 6, max = 6)
    val code: String,
) {
    fun toDomainRequest() = VerifyAuthCodeRequest(
        email = email,
        code = code,
    )
}
