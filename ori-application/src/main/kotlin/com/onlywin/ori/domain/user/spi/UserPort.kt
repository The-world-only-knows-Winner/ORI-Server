package com.onlywin.ori.domain.user.spi

import com.onlywin.ori.domain.user.User
import java.util.UUID

interface UserPort : CommandUserPort, QueryUserPort

interface CommandUserPort {
    fun saveUser(user: User)
}

interface QueryUserPort {
    fun queryUserById(id: UUID): User?
    fun queryUserByEmail(email: String): User?
    fun existsUserByEmail(email: String): Boolean
}
