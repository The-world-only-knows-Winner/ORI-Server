package com.onlywin.ori.common.spi

import java.util.UUID

interface SecurityPort {
    fun encodePassword(password: String): String
    fun getCurrentUserId(): UUID
    fun passwordMatches(rawPassword: String, encodePassword: String): Boolean
}
