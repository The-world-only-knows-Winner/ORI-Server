package com.onlywin.ori.station.domain

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface StationRepository : CrudRepository<StationEntity, UUID>
