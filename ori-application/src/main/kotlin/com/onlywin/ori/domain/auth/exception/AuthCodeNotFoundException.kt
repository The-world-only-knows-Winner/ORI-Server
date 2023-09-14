package com.onlywin.ori.domain.auth.exception

import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.domain.auth.exception.error.AuthErrorCode

object AuthCodeNotFoundException : OriException(
    AuthErrorCode.AUTH_CODE_NOT_FOUND,
)
