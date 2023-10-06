package com.onlywin.ori.domain.auth.exception.error

import com.onlywin.ori.common.error.ErrorProperty

enum class AuthErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    INVALID_AUTH_CODE(401, "Invalid Auth Code"),

    UN_AUTHORIZED(401, "Un Authorized"),
    PASSWORD_MIS_MATCH(401, "Password Mis Matches"),

    UNVERIFIED_EMAIL(403, "Unverified Email"),

    AUTH_CODE_NOT_FOUND(404, "Auth Code Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    EMAIL_NOT_FOUND(404, "Email Not Found"),
}
