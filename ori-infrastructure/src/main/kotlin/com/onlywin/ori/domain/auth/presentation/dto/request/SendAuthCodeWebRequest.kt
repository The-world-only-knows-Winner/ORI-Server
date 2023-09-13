package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.request.SendAuthCodeRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SendAuthCodeWebRequest(

    @NotBlank
    @Email
    val email: String,
) {
    fun toDomainRequest() = SendAuthCodeRequest(email)
}
