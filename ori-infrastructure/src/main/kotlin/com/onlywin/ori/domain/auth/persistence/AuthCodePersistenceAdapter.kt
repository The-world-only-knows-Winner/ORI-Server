package com.onlywin.ori.domain.auth.persistence

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.domain.auth.AuthCode
import com.onlywin.ori.domain.auth.spi.AuthCodePort
import org.springframework.data.repository.findByIdOrNull

@Adapter
class AuthCodePersistenceAdapter(
    private val authCodeRepository: AuthCodeRepository,
    private val authCodeMapper: AuthCodeMapper,
) : AuthCodePort {

    override fun queryAuthCodeByEmail(email: String) = authCodeMapper.authCodeEntityToDomain(
            authCodeRepository.findByIdOrNull(email)
    )

    override fun saveAuthCode(authCode: AuthCode) = authCodeMapper.authCodeEntityToDomain(
        authCodeRepository.save(
            authCodeMapper.authCodeDomainToEntity(authCode)
        )
    )!!
}
