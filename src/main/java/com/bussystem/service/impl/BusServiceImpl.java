package com.bussystem.service.impl;

import com.bussystem.dto.BusDto;
import com.bussystem.entity.Bus;
import com.bussystem.exception.ResourceNotFoundException;
import com.bussystem.repository.BusRepository;
import com.bussystem.service.BusService;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    private ModelMapper modelMapper;

    public BusServiceImpl(BusRepository busRepository, ModelMapper modelMapper) {
        this.busRepository = busRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BusDto saveBus(BusDto busDto) {
        Bus bus = mapToBus(busDto);
        Bus saveBus = busRepository.save(bus);
        BusDto busDto1 = mapToBusDto(saveBus);
        return busDto1;
    }

    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    public List<BusDto> getAllBuses() {
        List<Bus> buses =busRepository.findAll();
        List<BusDto> collect = buses.stream().map(e -> mapToBusDto(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Bus not found of that id: " + id)
        );
        BusDto busDto = mapToBusDto(bus);
        return busDto;
    }

    @Override
    public BusDto updateBusById(Long id, BusDto busDto) {
        Bus bus = busRepository.findById(id).get();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBustype(busDto.getBustype());
        bus.setTotleseats(busDto.getTotleseats());
        bus.setAvailableseats(busDto.getAvailableseats());
        bus.setBusPrice(busDto.getBusPrice());
        Bus save = busRepository.save(bus);

        return mapToBusDto(save);

    }

    Bus mapToBus(BusDto busDto){
//        Bus bus = new  Bus();
//        bus.setBusNumber(busDto.getBusNumber());
//        bus.setBustype(busDto.getBustype());
//        bus.setTotleseats(busDto.getTotleseats());
//        bus.setAvailableseats(busDto.getAvailableseats());
//        bus.setBusPrice(busDto.getBusPrice());
        Bus bus = modelMapper.map(busDto, Bus.class);
        return bus;

    }
    BusDto mapToBusDto(Bus bus){
//        BusDto dto = new BusDto();
//        dto.setId(bus.getId());
//        dto.setBusNumber(bus.getBusNumber());
//        dto.setTotleseats(bus.getTotleseats());
//        dto.setAvailableseats(bus.getAvailableseats());
//        dto.setBustype(bus.getBustype());
//        dto.setBusPrice(bus.getBusPrice());
        BusDto dto = modelMapper.map(bus, BusDto.class);
        return dto;

    }




}
