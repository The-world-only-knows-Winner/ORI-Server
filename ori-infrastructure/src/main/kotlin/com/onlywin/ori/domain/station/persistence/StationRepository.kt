package com.onlywin.ori.domain.station.persistence

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface StationRepository : CrudRepository<StationEntity, UUID>
