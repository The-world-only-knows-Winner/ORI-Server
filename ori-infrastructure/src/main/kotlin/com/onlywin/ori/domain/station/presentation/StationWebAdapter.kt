package com.onlywin.ori.domain.station.presentation

import com.onlywin.ori.domain.station.dto.response.QueryStationList
import com.onlywin.ori.domain.station.usecase.QueryStationUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/station")
@RestController
class StationWebAdapter(
    private val queryStationUseCase: QueryStationUseCase,
) {

    @GetMapping
    fun getStationByStationName(
        @RequestParam("station_name")
        stationName: String,
    ): QueryStationList {
        return queryStationUseCase.execute(stationName)
    }
}
