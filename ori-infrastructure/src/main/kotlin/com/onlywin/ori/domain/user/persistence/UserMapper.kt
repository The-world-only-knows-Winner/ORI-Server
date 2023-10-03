package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.domain.user.User
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class UserMapper {
    abstract fun userDomainToEntity(user: User): UserEntity
    abstract fun userEntityToDomain(userEntity: UserEntity?): User?
}
