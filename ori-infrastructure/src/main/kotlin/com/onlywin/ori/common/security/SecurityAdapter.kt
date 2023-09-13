package com.onlywin.ori.common.security

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.user.persistence.UserPersistenceAdapter
import com.onlywin.ori.domain.user.persistence.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.UUID

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder,
) : SecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun getCurrentUserId(): UUID = UUID.fromString(
        SecurityContextHolder.getContext().authentication.name
    )
}
