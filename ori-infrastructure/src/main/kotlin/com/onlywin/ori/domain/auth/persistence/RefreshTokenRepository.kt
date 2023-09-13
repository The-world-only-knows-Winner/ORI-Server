package com.onlywin.ori.domain.auth.persistence

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, UUID>