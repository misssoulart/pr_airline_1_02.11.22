package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.PassengerController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDto;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;
import ru.kataproject.p_sm_airlines_1.service.PassengerService;
import ru.kataproject.p_sm_airlines_1.util.mapper.PassengerMapper;

import java.util.*;

@RestController
public class PassengerControllerImpl implements PassengerController {
    private final PassengerService passengerService;

    public PassengerControllerImpl(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> getPassengerById(Long id) {
        PassengerDto passengerDto = PassengerMapper.entityToDto(passengerService.getPassengerById(id));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> createPassenger(PassengerDto passengerDto) {
        passengerService.savePassenger(PassengerMapper.dtoToEntity(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PassengerDto> updatePassenger(PassengerDto passengerDto) {
        passengerService.updatePassenger(PassengerMapper.dtoToEntity(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePassengerById(Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        passengerService.deletePassengerById(passenger.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

