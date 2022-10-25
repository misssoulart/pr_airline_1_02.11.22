package ru.kataproject.p_sm_airlines_1.controller.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.FlightController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDto;
import ru.kataproject.p_sm_airlines_1.entity.Flight;
import ru.kataproject.p_sm_airlines_1.service.FlightService;
import ru.kataproject.p_sm_airlines_1.util.mapper.FlightMapper;

/**
 * Контроллер для обработки запросов по добавлению, изминению и получению данных рейса
 *
 * (C)Toboe512
 */
@Log4j2
@RestController
public class FlightControllerImpl implements FlightController {

    private final FlightService flightService;

    public FlightControllerImpl(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public ResponseEntity<FlightDto> getFlightById(Long id) {
        log.info("execute getFlightById method");
        FlightDto flight = FlightMapper.mapped(flightService.getFlightById(id));
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createFlight(FlightDto flight) {
        log.info("execute createFlight method");
        flightService.saveFlight(FlightMapper.mapped(flight));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateFlight(FlightDto flight) {
        log.info("execute updateFlight method");
        flightService.updateFlight(FlightMapper.mapped(flight));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteFlightById(Long id) {
        log.info("execute deleteFlightById method");
        flightService.delete(flightService.getFlightById(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //TODO после добавления Seat доработать
    @Override
    public ResponseEntity<String> getFreeSeatsOnFlight(FlightDto flight) {
        log.info("execute getFreeSeatsOnFlight method");
        return null;
    }
}
