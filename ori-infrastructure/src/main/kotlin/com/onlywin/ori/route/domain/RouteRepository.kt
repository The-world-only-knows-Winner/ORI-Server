package com.onlywin.ori.route.domain

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RouteRepository : CrudRepository<RouteEntity, UUID>
