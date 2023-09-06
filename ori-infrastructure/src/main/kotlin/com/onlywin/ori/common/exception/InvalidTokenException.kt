package com.onlywin.ori.common.exception

import com.onlywin.ori.common.error.GlobalErrorCode
import com.onlywin.ori.common.error.OriException

object InvalidTokenException : OriException(
    GlobalErrorCode.INVALID_TOKEN
) {
    private fun readResolve(): Any = InvalidTokenException
}