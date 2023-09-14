package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.domain.user.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): User
}
