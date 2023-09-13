package com.onlywin.ori.domain.route.persistence

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RouteRepository : CrudRepository<RouteEntity, UUID>
