package com.onlywin.ori.domain.user.exception.error

import com.onlywin.ori.common.error.ErrorProperty

enum class UserErrorCode(
    override val status: Int,
    override val message: String,
): ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found"),
}