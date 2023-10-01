package com.onlywin.ori.domain.auth.exception

import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.domain.auth.exception.error.AuthErrorCode

object PasswordMisMatchException : OriException(
    AuthErrorCode.PASSWORD_MIS_MATCH,
)
