package com.onlywin.ori.common.exception

import com.onlywin.ori.common.error.GlobalErrorCode
import com.onlywin.ori.common.error.OriException

object InternalServerErrorException : OriException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR,
)
