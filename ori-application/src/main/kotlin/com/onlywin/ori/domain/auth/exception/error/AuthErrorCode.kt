package com.onlywin.ori.domain.auth.exception.error

import com.onlywin.ori.common.error.ErrorProperty

enum class AuthErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    INVALID_AUTH_CODE(401, "Invalid Auth Code"),

    UNVERIFIED_EMAIL(403, "Unverified Email"),

    AUTH_CODE_NOT_FOUND(404, "Auth Code Not Found"),
}