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
        val (startXPoint, startYPoint, endXPoint, endYPoint, totalTime, subRouteList) = request
        val routeId = commandRoutePort.saveRouteAndGetId(
            Route(
                startXPoint = startXPoint,
                startYPoint = startYPoint,
                endXPoint = endXPoint,
                endYPoint = endYPoint,
                time = totalTime,
                userId = securityPort.getCurrentUserId(),
            ),
        )

        commandStationPort.saveAllStation(
            subRouteList.map { subRoute ->
                Station(
                    busNumber = subRoute.busNumber,
                    stationName = subRoute.stationName,
                    index = subRoute.index,
                    time = subRoute.sectionTime,
                    routeId = routeId,
                )
            },
        )
    }
}
