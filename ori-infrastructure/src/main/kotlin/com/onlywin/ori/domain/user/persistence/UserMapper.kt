package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.domain.user.model.User
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper {
    abstract fun userDomainToEntity(user: User): UserEntity
    abstract fun userEntityToDomain(userEntity: UserEntity): User
}
