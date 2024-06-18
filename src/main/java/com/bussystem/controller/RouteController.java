package com.bussystem.controller;

import com.bussystem.dto.RouteDto;
import com.bussystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        RouteDto routeDto1 = routeService.saveRoute(routeDto);
        return new ResponseEntity<>(routeDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id){

        routeService.deleteRoute(id);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/allRoutes")
    public ResponseEntity<List<RouteDto>> getAllRoutes(){
        List<RouteDto> allRoutes = routeService.getAllRoutes();
        return new ResponseEntity<>(allRoutes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable Long id){
        RouteDto routeDto = routeService.getRouteById(id);
        return new ResponseEntity<>(routeDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRoute(@PathVariable Long id, @RequestBody RouteDto dto){
        routeService.updateById(id, dto);
        return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
    }
}
