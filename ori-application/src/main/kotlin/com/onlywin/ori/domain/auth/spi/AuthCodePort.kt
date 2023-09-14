package com.onlywin.ori.domain.auth.spi

import com.onlywin.ori.domain.auth.AuthCode

interface AuthCodePort : QueryAuthCodePort, CommendAuthCodePort

interface QueryAuthCodePort {
    fun queryAuthCodeByEmail(email: String): AuthCode?
}

interface CommendAuthCodePort {
    fun saveAuthCode(authCode: AuthCode): AuthCode
}
