package com.bussystem.service;

import com.bussystem.dto.RouteDto;

import java.util.List;

public interface RouteService {


    RouteDto saveRoute(RouteDto routeDto);

    void deleteRoute(Long id);

    RouteDto getRouteById(Long id);

    List<RouteDto> getAllRoutes();


    RouteDto updateById(Long id, RouteDto dto);
}
