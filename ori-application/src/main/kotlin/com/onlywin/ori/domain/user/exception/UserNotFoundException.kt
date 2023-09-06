package com.onlywin.ori.domain.user.exception

import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.domain.user.exception.error.UserErrorCode

object UserNotFoundException: OriException(
    UserErrorCode.USER_NOT_FOUND
) {
    private fun readResolve(): Any = UserNotFoundException
}