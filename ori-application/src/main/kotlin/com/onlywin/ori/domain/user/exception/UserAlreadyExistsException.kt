package com.onlywin.ori.domain.user.exception

import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.domain.user.exception.error.UserErrorCode

object UserAlreadyExistsException : OriException(
    UserErrorCode.USER_ALREADY_EXISTS,
)
