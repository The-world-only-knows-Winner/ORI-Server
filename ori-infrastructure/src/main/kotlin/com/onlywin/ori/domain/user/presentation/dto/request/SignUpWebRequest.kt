package com.onlywin.ori.domain.user.presentation.dto.request

import com.onlywin.ori.domain.user.dto.request.SignUpRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class SignUpWebRequest(

    @field:NotBlank
    @field:Email
    val email: String,

    @field:Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$")
    val password: String,

    @field:NotBlank
    val name: String,

    @field:NotNull
    val birthday: LocalDate,

    @field:NotBlank
    val deviceToken: String,
) {
    fun toDomainRequest() = SignUpRequest(
        email = email,
        password = password,
        name = name,
        birthday = birthday,
        deviceToken = deviceToken,
    )
}
