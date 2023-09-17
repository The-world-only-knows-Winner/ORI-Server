package com.onlywin.ori.domain.auth.spi

import com.onlywin.ori.domain.auth.AuthCode

interface AuthCodePort : CommendAuthCodePort, QueryAuthCodePort

interface CommendAuthCodePort {
    fun saveAuthCode(authCode: AuthCode): AuthCode
}

interface QueryAuthCodePort {
    fun queryAuthCodeByEmail(email: String): AuthCode?
}
