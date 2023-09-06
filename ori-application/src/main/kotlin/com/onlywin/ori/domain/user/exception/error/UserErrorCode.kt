package com.onlywin.ori.domain.user.exception.error

import com.onlywin.ori.common.error.ErrorProperty
import com.onlywin.ori.common.error.HttpStatus

enum class UserErrorCode(
    override val status: HttpStatus,
    override val message: String,
): ErrorProperty {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
}