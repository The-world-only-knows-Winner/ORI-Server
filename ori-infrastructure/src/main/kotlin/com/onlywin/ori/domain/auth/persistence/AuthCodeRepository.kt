package com.onlywin.ori.domain.auth.persistence

import org.springframework.data.repository.CrudRepository

interface AuthCodeRepository : CrudRepository<AuthCodeEntity, String>
