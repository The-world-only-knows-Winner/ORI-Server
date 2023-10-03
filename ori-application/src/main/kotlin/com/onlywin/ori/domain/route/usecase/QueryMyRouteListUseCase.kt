package com.onlywin.ori.domain.route.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.route.dto.response.QueryMyRouteListResponse
import com.onlywin.ori.domain.route.spi.QueryRoutePort

@UseCase
class QueryMyRouteListUseCase(
    private val queryRoutePort: QueryRoutePort,
    private val securityPort: SecurityPort,
) {

    fun execute(): QueryMyRouteListResponse {
        val userId = securityPort.getCurrentUserId()

        return QueryMyRouteListResponse(
            queryRoutePort.queryRouteListByUserId(userId)
        )
    }
}