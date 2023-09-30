package com.onlywin.ori.domain.user.presentation.dto.request

import com.onlywin.ori.domain.user.dto.request.UpdateUserInfoRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class UpdateUserInfoWebRequest(

    @field:NotBlank
    val name: String,

    @field:NotNull
    val birthday: LocalDate,
) {
    fun toDomainRequest() = UpdateUserInfoRequest(
        name = name,
        birthday = birthday,
    )
}
