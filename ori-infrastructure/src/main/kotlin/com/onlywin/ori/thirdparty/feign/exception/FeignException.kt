package com.onlywin.ori.thirdparty.feign.exception

import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.thirdparty.feign.error.FeignErrorCode

object FeignBadRequestException : OriException(
    FeignErrorCode.FEIGN_BAD_REQUEST,
)

object FeignUnAuthorizedException : OriException(
    FeignErrorCode.FEIGN_UNAUTHORIZED,
)

object FeignExpiredTokenException : OriException(
    FeignErrorCode.FEIGN_EXPIRED_TOKEN,
)

object FeignForbiddenException : OriException(
    FeignErrorCode.FEIGN_FORBIDDEN,
)

object FeignInternalServerErrorException : OriException(
    FeignErrorCode.FEIGN_INTERNAL_SERVER_ERROR,
)
