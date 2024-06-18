package com.bussystem.controller;



import com.bussystem.dto.BusDto;
import com.bussystem.entity.Bus;
import com.bussystem.repository.BusRepository;
import com.bussystem.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private BusRepository busRepository;

    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto){
        BusDto dto = busService.saveBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id){
        Bus bus = busRepository.findById(id).get();
        busRepository.delete(bus);
        //  busService.deleteBus(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBuses(){
        List<BusDto> allBuses = busService.getAllBuses();
        return new ResponseEntity<>(allBuses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable Long id){
        BusDto busById = busService.getBusById(id);
        return new ResponseEntity<>(busById,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBus(@PathVariable Long id, @RequestBody BusDto busDto){
        BusDto busDto1 = busService.updateBusById(id, busDto);
        return new ResponseEntity<>(busDto1,HttpStatus.CREATED);
    }
}
