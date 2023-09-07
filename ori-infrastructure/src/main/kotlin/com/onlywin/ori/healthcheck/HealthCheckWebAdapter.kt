package com.onlywin.ori.healthcheck

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/check")
@RestController
class HealthCheckWebAdapter {

    @GetMapping
    fun healthCheck(): String = "Health Check"
}
