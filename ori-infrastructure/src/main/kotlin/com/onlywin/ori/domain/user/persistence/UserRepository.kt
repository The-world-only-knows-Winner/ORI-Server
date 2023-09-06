package com.onlywin.ori.domain.user.persistence

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<UserEntity, UUID>
