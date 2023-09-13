package com.onlywin.ori.common.feign.error

import com.onlywin.ori.common.error.ErrorProperty

enum class FeignErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),
    FEIGN_FORBIDDEN(403, "Feign Forbidden."),
    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token."),
    FEIGN_INTERNAL_SERVER_ERROR(500, "Feign Internal Server Error.");
}
