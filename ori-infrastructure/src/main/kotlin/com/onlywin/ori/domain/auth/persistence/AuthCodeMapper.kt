package com.onlywin.ori.domain.auth.persistence

import com.onlywin.ori.domain.auth.AuthCode
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class AuthCodeMapper {
    abstract fun authCodeDomainToEntity(authCode: AuthCode): AuthCodeEntity
    abstract fun authCodeEntityToDomain(authCodeEntity: AuthCodeEntity?): AuthCode?
}
