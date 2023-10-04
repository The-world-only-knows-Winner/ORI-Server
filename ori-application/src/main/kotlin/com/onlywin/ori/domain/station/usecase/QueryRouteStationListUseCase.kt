package com.onlywin.ori.domain.station.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.station.dto.response.QueryRouteStationListResponse
import com.onlywin.ori.domain.station.spi.QueryStationPort
import java.util.UUID

@UseCase
class QueryRouteStationListUseCase(
    private val queryStationPort: QueryStationPort,
) {

    fun execute(routeId: UUID): QueryRouteStationListResponse = QueryRouteStationListResponse(
        queryStationPort.queryStationByRouteId(routeId)
    )
}