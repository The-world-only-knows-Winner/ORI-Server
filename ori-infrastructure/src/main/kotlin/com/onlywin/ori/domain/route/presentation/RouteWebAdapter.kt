package com.onlywin.ori.domain.route.presentation

import com.onlywin.ori.domain.route.dto.response.QueryMyRouteListResponse
import com.onlywin.ori.domain.route.dto.response.QueryRouteList
import com.onlywin.ori.domain.route.presentation.dto.request.AddRouteWebRequest
import com.onlywin.ori.domain.route.usecase.AddRouteUseCase
import com.onlywin.ori.domain.route.usecase.QueryMyRouteListUseCase
import com.onlywin.ori.domain.route.usecase.QueryRouteUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/route")
@RestController
class RouteWebAdapter(
    private val queryRouteUseCase: QueryRouteUseCase,
    private val addRouteUseCase: AddRouteUseCase,
    private val queryMyRouteListUseCase: QueryMyRouteListUseCase,
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addRoute(
        @RequestBody @Valid
        request: AddRouteWebRequest,
    ) {
        addRouteUseCase.execute(request.toDomainRequest())
    }

    @GetMapping("my")
    fun getMyRoute(): QueryMyRouteListResponse {
        return queryMyRouteListUseCase.execute()
    }
}
