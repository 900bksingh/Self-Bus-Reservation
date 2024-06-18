package com.bussystem.service.impl;

import com.bussystem.dto.RouteDto;
import com.bussystem.entity.Route;
import com.bussystem.repository.RouteRepository;
import com.bussystem.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RouteDto saveRoute(RouteDto routeDto) {

        Route route = mapToRoute(routeDto);
        Route save = routeRepository.save(route);
        RouteDto routeDto1 = mapToRouteDto(save);
        return routeDto1;

    }

    @Override
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public RouteDto getRouteById(Long id) {

        Route routeById = routeRepository.findById(id).get();
        RouteDto routeDto = mapToRouteDto(routeById);
        return routeDto;
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        List<Route> routeAll = routeRepository.findAll();
        List<RouteDto> collectRoute = routeAll.stream().map(e -> mapToRouteDto(e)).collect(Collectors.toList());
        return collectRoute;
    }

    @Override
    public RouteDto updateById(Long id, RouteDto dto) {
        Route route = routeRepository.findById(id).get();
        route.setFromLocation(dto.getFromLocation());
        route.setToLocation(dto.getToLocation());
        route .setFromDate(dto.getFromDate());
        route.setToDate(dto.getToDate());
        route.setTotalDuration(dto.getTotalDuration());
        route.setFromTime(dto.getFromTime());
        route.setToTime(dto.getToTime());
       Route route1 = routeRepository.save(route);
        return mapToRouteDto(route1);

    }


    Route mapToRoute(RouteDto routeDto){
//        Route route= new Route();
//        route.setFromLocation(routeDto.getFromLocation());
//        route.setToLocation(routeDto.getToLocation());
//        route .setFromDate(routeDto.getFromDate());
//        route.setToDate(routeDto.getToDate());
//        route.setTotalDuration(routeDto.getTotalDuration());
//        route.setFromTime(routeDto.getFromTime());
//        route.setToTime(routeDto.getToTime());
        Route route = modelMapper.map(routeDto, Route.class);
        return route;
    }
    RouteDto mapToRouteDto(Route route){
//        RouteDto routeDto2 = new RouteDto();
//        routeDto2.setId(route.getId());
//        routeDto2.setFromLocation(route.getFromLocation());
//        routeDto2.setToLocation(route.getToLocation());
//        routeDto2 .setFromDate(route.getFromDate());
//        routeDto2.setToDate(route.getToDate());
//        routeDto2.setTotalDuration(route.getTotalDuration());
//        routeDto2.setFromTime(route.getFromTime());
//        routeDto2.setToTime(route.getToTime());
        RouteDto routeDto2 = modelMapper.map(route, RouteDto.class);
        return routeDto2;

    }
}
