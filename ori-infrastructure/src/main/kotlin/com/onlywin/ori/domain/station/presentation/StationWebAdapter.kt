package com.onlywin.ori.domain.station.presentation

import com.onlywin.ori.domain.station.dto.response.QueryRouteStationListResponse
import com.onlywin.ori.domain.station.dto.response.QueryStationList
import com.onlywin.ori.domain.station.usecase.QueryRouteStationListUseCase
import com.onlywin.ori.domain.station.usecase.QueryStationUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/station")
@RestController
class StationWebAdapter(
    private val queryStationUseCase: QueryStationUseCase,
    private val queryRouteStationListUseCase: QueryRouteStationListUseCase
) {

    @GetMapping
    fun getStationByStationName(
        @RequestParam("station_name")
        stationName: String,
    ): QueryStationList {
        return queryStationUseCase.execute(stationName)
    }

    @GetMapping("/{route-id}")
    fun getStationByRouteId(
        @PathVariable("route-id") routeId: UUID,
    ): QueryRouteStationListResponse {
        return queryRouteStationListUseCase.execute(routeId)
    }
}
