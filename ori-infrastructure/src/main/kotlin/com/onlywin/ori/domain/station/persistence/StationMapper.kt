package com.onlywin.ori.domain.station.persistence

import com.onlywin.ori.domain.route.persistence.RouteRepository
import com.onlywin.ori.domain.station.Station
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring")
abstract class StationMapper {

    @Autowired
    lateinit var routeRepository: RouteRepository

    @Mapping(target = "route", expression = "java(routeRepository.findById(station.getRouteId()).orElse(null))")
    abstract fun stationDomainToEntity(station: Station): StationEntity

    @Mapping(target = "routeId", expression = "java(stationEntity.getRoute().getId())")
    abstract fun stationEntityToDomain(stationEntity: StationEntity): Station
}
