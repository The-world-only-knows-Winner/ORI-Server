package com.onlywin.ori.domain.auth.persistence

import com.onlywin.ori.domain.auth.AuthCode
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class AuthCodeMapper {
    abstract fun authCodeDomainToEntity(authCode: AuthCode): AuthCodeEntity
    abstract fun authCodeEntityToDomain(authCodeEntity: AuthCodeEntity?): AuthCode?
}
