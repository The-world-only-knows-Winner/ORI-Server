package com.onlywin.ori.domain.auth.dto.request

data class ChangePasswordRequest(
    val oldPassword: String,
    val newPassword: String,
)
