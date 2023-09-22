package com.onlywin.ori.thirdparty.feign.client.station

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "StationClient", url = "\${api.host}")
interface StationClient {

    @GetMapping("/searchStation")
    fun getStationByStationName(
        @RequestParam("apiKey") apiKey: String,
        @RequestParam("stationName") stationName: String,
    ): String


}
