package com.onlywin.ori.domain.auth

import com.onlywin.ori.common.annotation.Aggregate
import com.onlywin.ori.domain.auth.exception.InvalidAuthCodeException

@Aggregate
data class AuthCode(
    val id: String,
    val code: String,
    val verified: Boolean,
    val ttl: Long,
) {

    fun verifyAuthCode(code: String): AuthCode {
        if (code != this.code) {
            throw InvalidAuthCodeException
        }

        return copy(verified = true)
    }
}
