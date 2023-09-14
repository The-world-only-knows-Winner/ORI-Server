package com.onlywin.ori.domain.user.persistence

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.domain.user.User
import com.onlywin.ori.domain.user.spi.UserPort
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
) : UserPort {

    override fun saveUser(user: User): User = userMapper.userEntityToDomain(
        userRepository.save(userMapper.userDomainToEntity(user)),
    )!!

    override fun queryUserById(id: UUID): User? = userMapper.userEntityToDomain(
        userRepository.findByIdOrNull(id),
    )

    override fun queryUserByEmail(email: String): User? =
        userRepository.findByEmail(email)

    override fun existsUserByEmail(email: String): Boolean =
        userRepository.existsByEmail(email)
}
