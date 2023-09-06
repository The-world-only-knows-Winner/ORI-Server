package com.onlywin.ori.common.error.response

import com.onlywin.ori.common.error.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: String,
)
