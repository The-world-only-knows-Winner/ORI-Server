package com.onlywin.ori.domain.station.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.domain.station.dto.response.QueryStationList
import com.onlywin.ori.domain.station.spi.QueryStationPort

@UseCase
class QueryStationUseCase(
    private val queryStationPort: QueryStationPort,
) {

    fun execute(stationName: String) = QueryStationList(
        queryStationPort.queryStationByStationName(stationName),
    )
}
