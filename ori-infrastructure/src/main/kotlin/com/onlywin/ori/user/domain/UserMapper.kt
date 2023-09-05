package com.onlywin.ori.user.domain

import com.onlywin.ori.user.User
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun userDomainToEntity(user: User): UserEntity
    fun userEntityToDomain(userEntity: UserEntity): User
}
