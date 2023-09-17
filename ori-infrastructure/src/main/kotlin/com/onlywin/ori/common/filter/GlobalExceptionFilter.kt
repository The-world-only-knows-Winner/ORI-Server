package com.onlywin.ori.common.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.onlywin.ori.common.error.ErrorProperty
import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.common.error.response.ErrorResponse
import com.onlywin.ori.common.exception.InternalServerErrorException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e.cause) {
                is OriException -> {
                    writeErrorResponse(response, (e.cause as OriException).errorProperty)
                }

                is Exception -> {
                    e.printStackTrace()
                    writeErrorResponse(response, InternalServerErrorException.errorProperty)
                }
            }
        }
    }

    private fun writeErrorResponse(response: HttpServletResponse, errorProperty: ErrorProperty) {
        val errorResponse = ErrorResponse(errorProperty.status, errorProperty.message)
        response.apply {
            status = errorProperty.status
            contentType = MediaType.APPLICATION_JSON_VALUE
            characterEncoding = StandardCharsets.UTF_8.name()
            writer.write(objectMapper.writeValueAsString(errorResponse))
        }
    }
}
