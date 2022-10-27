package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.kataproject.p_sm_airlines_1.controller.SeatController;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.util.mapper.SeatMapper;
import ru.kataproject.p_sm_airlines_1.entity.SeatCategory;
import ru.kataproject.p_sm_airlines_1.service.SeatService;
import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Controller for processing requests for add, change and get seat data.
 * Implements interface SeatController
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 12.10.2022
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;

    @Override
    public ResponseEntity<HttpStatus> createSeat(SeatDTO seatDTO) {
        log.info("execute createSeat method");
        seatService.saveSeat(SeatMapper.dtoToSeat(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateSeat(SeatDTO seatDTO) {
        log.info("execute updateSeat method");
        seatService.updateSeat(SeatMapper.dtoToSeat(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSeat(Long id) {
        log.info("execute deleteSeat method");
        Seat seat = seatService.getSeatById(id);
        seatService.deleteSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public List<SeatDTO> getAllSeatsOnFlight(Long flightId) {
        log.info("execute getAllSeatsOnFlight method");
        List<Seat> seats = seatService.getSeatByFlightId(flightId);
        return seats.stream().map(SeatMapper::seatToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SeatDTO> getSeatsOnFlightByCategory(Long flightId, SeatCategory seatCategory) {
        log.info("execute getSeatsOnFlightByCategory method");
        List<Seat> seats = seatService.getSeatByFlightIdAndCategory(flightId, seatCategory);
        return seats.stream().map(SeatMapper::seatToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Integer> getNumberOfSoldSeats(Long flightId) {
        log.info("execute getNumberOfSoldSeats method");
        return new ResponseEntity<>(seatService.getNumberOfSoldSeats(flightId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfUnsoldSeats(Long flightId) {
        log.info("execute getNumberOfUnsoldSeats method");
        return new ResponseEntity<>(seatService.getNumberOfUnsoldSeats(flightId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfRegisteredPassengersOnFlight(Long flightId) {
        log.info("execute getNumberOfRegisteredPassengersOnFlight method");
        return new ResponseEntity<>(seatService.getNumberOfRegisteredPassengers(flightId), HttpStatus.OK);
    }
}