package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DestinationController;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.service.impl.DestinationServiceImpl;
import ru.kataproject.p_sm_airlines_1.util.mapper.DestinationMapper;

import java.util.List;

@RestController
public class DestinationControllerImpl implements DestinationController {
    DestinationServiceImpl destinationService;

    public DestinationControllerImpl(DestinationServiceImpl destinationService) {
        this.destinationService = destinationService;
    }

    @Override
    public ResponseEntity<HttpStatus> create(Destination destination) {
        destinationService.create(destination);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DestinationDTO> getById(Long id) {
        Destination destination = destinationService.getById(id);
        return destination != null
                ? new ResponseEntity<>(DestinationMapper.toDTO(destination), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<HttpStatus> update(Destination destination) {
        destinationService.update(destination);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        destinationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DestinationDTO>> getByCity(String city) {
        List<Destination> destinationList = destinationService.getByCity(city);
        return destinationList != null && !destinationList.isEmpty()
                ? new ResponseEntity<>(DestinationMapper.toDTOs(destinationList), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<DestinationDTO>> getByCountry(String country) {
        List<Destination> destinationList = destinationService.getByCountry(country);
        return destinationList != null && !destinationList.isEmpty()
                ? new ResponseEntity<>(DestinationMapper.toDTOs(destinationList), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}