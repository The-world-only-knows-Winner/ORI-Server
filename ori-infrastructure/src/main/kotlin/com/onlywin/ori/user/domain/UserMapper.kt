package com.onlywin.ori.user.domain

import com.onlywin.ori.user.User
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper {
    abstract fun userDomainToEntity(user: User): UserEntity
    abstract fun userEntityToDomain(userEntity: UserEntity): User
}
