package com.onlywin.ori.thirdparty.feign.client.route

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "Route", url = "\${api.host}")

interface RouteClient {

    @GetMapping("/searchPubTransPathT")
    fun getPublicTransitRoute(
        @RequestParam("apiKey") apiKey: String,
        @RequestParam("SX") startXPoint: Float,
        @RequestParam("SY") startYPoint: Float,
        @RequestParam("EX") endXPoint: Float,
        @RequestParam("EY") endYPoint: Float,
        @RequestParam("SearchPathType") searchPathType: Int
    ): String
}