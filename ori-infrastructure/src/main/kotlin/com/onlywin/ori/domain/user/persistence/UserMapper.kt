package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.domain.user.User
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class UserMapper {
    abstract fun userDomainToEntity(user: User): UserEntity
    abstract fun userEntityToDomain(userEntity: UserEntity?): User?
}
