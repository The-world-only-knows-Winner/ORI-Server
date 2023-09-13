package com.onlywin.ori.domain.user.spi

import com.onlywin.ori.domain.user.User
import java.util.UUID

interface UserPort : CommandUserPort, QueryUserPort {
}

interface QueryUserPort {
    fun queryUserById(id: UUID): User?
    fun existsUserByEmail(email: String): Boolean
}

interface CommandUserPort {
    fun saveUser(user: User): User
}