package com.onlywin.ori.domain.route.presentation

import com.onlywin.ori.domain.route.dto.response.QueryRouteList
import com.onlywin.ori.domain.route.usecase.QueryRouteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/route")
@RestController
class RouteWebAdapter(
    private val queryRouteUseCase: QueryRouteUseCase,
) {

    @GetMapping
    fun getRouteByPoint(
        @RequestParam("start_x_point") startXPoint: Float,
        @RequestParam("start_y_point") startYPoint: Float,
        @RequestParam("end_x_point") endXPoint: Float,
        @RequestParam("end_y_point") endYPoint: Float,
    ): QueryRouteList {
        return queryRouteUseCase.execute(startXPoint, startYPoint, endXPoint, endYPoint)
    }
}
