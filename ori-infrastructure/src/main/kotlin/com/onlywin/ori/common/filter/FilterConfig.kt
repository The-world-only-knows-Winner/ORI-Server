package com.onlywin.ori.common.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.onlywin.ori.common.security.jwt.JwtTokenParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(http: HttpSecurity) {
        http.addFilterBefore(JwtFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter::class.java)
        http.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtFilter::class.java)
    }
}
