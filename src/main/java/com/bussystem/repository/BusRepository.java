package com.bussystem.repository;

import com.bussystem.dto.BusDto;
import com.bussystem.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

}
