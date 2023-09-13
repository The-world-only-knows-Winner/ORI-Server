package com.onlywin.ori.domain.user.presentation.dto.request

import com.onlywin.ori.domain.user.dto.request.SignUpRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class SignUpWebRequest(

    @NotBlank
    @Email
    val email: String,

    @Pattern(regexp = "^(?=.[!@#\$%^&])[a-zA-Z0-9!@#\$%^&*]{8,20}\$")
    val password: String,

    @NotBlank
    val name: String,

    @NotNull
    val birthday: LocalDate,

    @NotBlank
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