package com.onlywin.ori.common.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.onlywin.ori.common.error.ErrorProperty
import com.onlywin.ori.common.error.GlobalErrorCode
import com.onlywin.ori.common.error.OriException
import com.onlywin.ori.common.error.response.ErrorResponse
import org.springframework.web.filter.OncePerRequestFilter
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
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
        } catch (e: OriException) {
            writeErrorResponse(response, e.errorProperty)
        } catch (e: Exception) {
            e.printStackTrace()
            writeErrorResponse(response, GlobalErrorCode.INTERNAL_SERVER_ERROR)
        }
    }

    private fun writeErrorResponse(response: HttpServletResponse, errorProperty: ErrorProperty) {
        response.apply {
            status = errorProperty.status
            contentType = MediaType.APPLICATION_JSON_VALUE
            characterEncoding = StandardCharsets.UTF_8.name()
        }
        val errorResponse = ErrorResponse(
            status = errorProperty.status,
            message = errorProperty.message,
        )
        response.writer.write(
            objectMapper.writeValueAsString(errorResponse),
        )
    }
}
