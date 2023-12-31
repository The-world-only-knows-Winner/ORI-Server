package com.onlywin.ori.domain.auth.persistence

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.domain.auth.RefreshToken
import com.onlywin.ori.domain.auth.spi.RefreshTokenPort
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper,
) : RefreshTokenPort {

    override fun deleteRefreshToken(refreshToken: RefreshToken) {
        refreshTokenRepository.delete(refreshTokenMapper.refreshTokenDomainToEntity(refreshToken))
    }

    override fun queryRefreshTokenByUserId(userId: UUID): RefreshToken? =
        refreshTokenMapper.refreshTokenEntityToDomain(refreshTokenRepository.findByIdOrNull(userId))

    override fun queryRefreshTokenByRefreshToken(refreshToken: String): RefreshToken? =
        refreshTokenMapper.refreshTokenEntityToDomain(refreshTokenRepository.findByToken(refreshToken))
}
