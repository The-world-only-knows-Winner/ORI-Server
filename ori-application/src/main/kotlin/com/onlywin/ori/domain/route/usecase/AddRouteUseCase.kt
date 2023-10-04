package com.onlywin.ori.domain.route.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.route.Route
import com.onlywin.ori.domain.route.dto.request.AddRouteRequest
import com.onlywin.ori.domain.route.spi.CommendRoutePort
import com.onlywin.ori.domain.station.Station
import com.onlywin.ori.domain.station.spi.CommandStationPort

@UseCase
class AddRouteUseCase(
    private val securityPort: SecurityPort,
    private val commandRoutePort: CommendRoutePort,
    private val commandStationPort: CommandStationPort,
) {

    fun execute(request: AddRouteRequest) {
        val (startName, startXPoint, startYPoint, endName, endXPoint, endYPoint, totalTime, subStationList) = request
        val routeId = commandRoutePort.saveRouteAndGetId(
            Route(
                startName = startName,
                startXPoint = startXPoint,
                startYPoint = startYPoint,
                endName = endName,
                endXPoint = endXPoint,
                endYPoint = endYPoint,
                time = totalTime,
                userId = securityPort.getCurrentUserId(),
            ),
        )

        commandStationPort.saveAllStation(
            subStationList.map { subStation ->
                Station(
                    busNumber = subStation.busNumber,
                    stationName = subStation.stationName,
                    index = subStation.index,
                    time = subStation.sectionTime,
                    routeId = routeId,
                )
            },
        )
    }
}
