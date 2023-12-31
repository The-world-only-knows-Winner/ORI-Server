package com.onlywin.ori.domain.user

import com.onlywin.ori.common.annotation.Aggregate
import java.time.LocalDate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID = UUID.randomUUID(),
    val email: String,
    val password: String,
    val name: String,
    val birthday: LocalDate,
) {
    fun updateUserInfo(name: String, birthday: LocalDate): User {
        return copy(
            name = name,
            birthday = birthday,
        )
    }

    fun changePassword(newPassword: String): User {
        return copy(password = newPassword)
    }
}
