package com.onlywin.ori.domain.route.persistence

import com.onlywin.ori.domain.user.persistence.UserRepository
import com.onlywin.ori.domain.route.Route
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring")
abstract class RouteMapper {

    @Autowired
    lateinit var userRepository: UserRepository

    @Mapping(target = "user", expression = "java(userRepository.findById(route.getUserId()).orElse(null))")
    abstract fun routeDomainToEntity(route: Route): RouteEntity

    @Mapping(target = "userId", expression = "java(routeEntity.getUser().getId())")
    abstract fun routeEntityToDomain(routeEntity: RouteEntity): Route
}
