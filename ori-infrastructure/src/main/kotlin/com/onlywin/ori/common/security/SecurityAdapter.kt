package com.onlywin.ori.common.security

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.common.spi.SecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder,
) : SecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun getCurrentUserId(): UUID = UUID.fromString(
        SecurityContextHolder.getContext().authentication.name,
    )

    override fun passwordMatches(rawPassword: String, encodePassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodePassword)
}
