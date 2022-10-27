package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.PassengerController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDto;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;
import ru.kataproject.p_sm_airlines_1.service.PassengerService;
import ru.kataproject.p_sm_airlines_1.util.mapper.PassengerMapper;

import java.util.*;

@Log4j2
@RestController
public class PassengerControllerImpl implements PassengerController {
    private final PassengerService passengerService;

    public PassengerControllerImpl(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        log.info("execute getAllPassengers method");
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> getPassengerById(Long id) {
        log.info("execute getPassengerById method");
        PassengerDto passengerDto = PassengerMapper.entityToDto(passengerService.getPassengerById(id));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> createPassenger(PassengerDto passengerDto) {
        log.info("execute createPassenger method");
        passengerService.savePassenger(PassengerMapper.dtoToEntity(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PassengerDto> updatePassenger(PassengerDto passengerDto) {
        log.info("execute updatePassenger method");
        passengerService.updatePassenger(PassengerMapper.dtoToEntity(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePassengerById(Long id) {
        log.info("execute deletePassengerById method");
        Passenger passenger = passengerService.getPassengerById(id);
        passengerService.deletePassengerById(passenger.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

