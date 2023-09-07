package com.onlywin.ori.station.domain

import com.onlywin.ori.route.domain.RouteRepository
import com.onlywin.ori.station.Station
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class StationMapper {

    @Autowired
    lateinit var routeRepository: RouteRepository

    @Mapping(target = "route", expression = "java(routeRepository.findById(station.getRouteId()).orElse(null))")
    abstract fun stationDomainToEntity(station: Station): StationEntity

    @Mapping(target = "routeId", expression = "java(stationEntity.getRoute().getId())")
    abstract fun stationEntityToDomain(stationEntity: StationEntity): Station
}
