package com.onlywin.ori.domain.auth.persistence

import com.onlywin.ori.domain.auth.RefreshToken
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper {
    abstract fun refreshTokenDomainToEntity(refreshToken: RefreshToken): RefreshTokenEntity
    abstract fun refreshTokenEntityToDomain(refreshTokenEntity: RefreshTokenEntity): RefreshToken
}