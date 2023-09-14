package com.onlywin.ori.common.annotation.config

import com.onlywin.ori.BASE_PACKAGE
import com.onlywin.ori.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = [BASE_PACKAGE],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [UseCase::class],
        ),
    ],
)
class AnnotationConfig
