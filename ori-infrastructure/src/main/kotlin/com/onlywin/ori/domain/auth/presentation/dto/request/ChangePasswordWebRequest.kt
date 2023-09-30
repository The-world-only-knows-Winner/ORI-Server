package com.onlywin.ori.domain.auth.presentation.dto.request

import com.onlywin.ori.domain.auth.dto.request.ChangePasswordRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class ChangePasswordWebRequest(

    @field:NotBlank
    val oldPassword: String,

    @field:Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$")
    val newPassword: String,
) {
    fun toDomainRequest() = ChangePasswordRequest(
        oldPassword = oldPassword,
        newPassword = newPassword,
    )
}
