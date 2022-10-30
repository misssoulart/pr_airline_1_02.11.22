package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.AircraftController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;
import ru.kataproject.p_sm_airlines_1.service.AircraftService;
import ru.kataproject.p_sm_airlines_1.util.mapper.AircraftMapper;

import java.util.List;

@RestController
public class AircraftControllerImpl implements AircraftController {
    private final AircraftService aircraftService;

    public AircraftControllerImpl(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @Override
    public ResponseEntity<List<AircraftDto>> getAllAircrafts() {
        return new ResponseEntity<>(aircraftService.getAllAircrafts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AircraftDto> getAircraftById(Long id) {
        AircraftDto aircraft = AircraftMapper.mapped(aircraftService.getAircraftById(id));
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createAircraft(AircraftDto aircraft) {
        aircraftService.saveAircraft(AircraftMapper.mapped(aircraft));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateAircraft(AircraftDto aircraft) {
        aircraftService.updateAircraft(AircraftMapper.mapped(aircraft));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAircraftById(Long id) {
        aircraftService.delete(aircraftService.getAircraftById(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

