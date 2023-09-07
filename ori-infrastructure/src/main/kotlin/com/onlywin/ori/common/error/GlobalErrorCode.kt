package com.onlywin.ori.common.error

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String
): ErrorProperty {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Invalid Token"),

}