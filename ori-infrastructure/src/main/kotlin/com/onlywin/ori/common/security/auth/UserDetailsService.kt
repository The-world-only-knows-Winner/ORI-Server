package com.onlywin.ori.common.security.auth

import com.onlywin.ori.domain.user.persistence.UserEntity
import com.onlywin.ori.domain.user.persistence.UserRepository
import com.onlywin.ori.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {

    override fun loadUserByUsername(userId: String?): UserDetails {
        val userEntity: UserEntity = userRepository.findByIdOrNull(UUID.fromString(userId))
            ?: throw UserNotFoundException

        return UserDetails(userEntity.id)
    }
}
