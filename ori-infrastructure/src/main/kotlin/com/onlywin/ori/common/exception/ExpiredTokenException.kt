package com.onlywin.ori.common.exception

import com.onlywin.ori.common.error.GlobalErrorCode
import com.onlywin.ori.common.error.OriException

object ExpiredTokenException : OriException(
    GlobalErrorCode.EXPIRED_TOKEN
) {
    private fun readResolve(): Any = ExpiredTokenException
}
