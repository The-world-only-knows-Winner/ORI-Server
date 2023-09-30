package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.request.SendAuthCodeRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SendAuthCodeWebRequest(

    @field:NotBlank
    @field:Email
    val email: String,
) {
    fun toDomainRequest() = SendAuthCodeRequest(email)
}
