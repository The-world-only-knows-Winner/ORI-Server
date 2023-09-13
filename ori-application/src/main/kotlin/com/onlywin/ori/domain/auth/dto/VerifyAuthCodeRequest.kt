package com.onlywin.ori.domain.auth.dto

data class VerifyAuthCodeRequest(
    val email: String,
    val code: String,
)
