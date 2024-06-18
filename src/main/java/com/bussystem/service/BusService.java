package com.bussystem.service;

import com.bussystem.dto.BusDto;

import java.util.List;

public interface BusService {

    BusDto saveBus(BusDto busDto);

    void deleteBus(Long id);

    List<BusDto> getAllBuses();


    BusDto getBusById(Long id);

    BusDto updateBusById(Long id, BusDto busDto);

}
