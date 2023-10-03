package com.onlywin.ori.domain.route.dto.response

import com.onlywin.ori.domain.route.spi.vo.MyRouteListVO

data class QueryMyRouteListResponse(
    val routeList: List<MyRouteListVO>,
)
