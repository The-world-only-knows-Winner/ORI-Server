package com.onlywin.ori.domain.auth.dto.request

data class VerifyAuthCodeRequest(
    val email: String,
    val code: String,
)
