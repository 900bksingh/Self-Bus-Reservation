package com.bussystem.repository;

import com.bussystem.dto.RouteDto;
import com.bussystem.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
