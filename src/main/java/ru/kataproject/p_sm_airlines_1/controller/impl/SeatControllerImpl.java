package ru.kataproject.p_sm_airlines_1.controller.impl;

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
@RestController
@RequiredArgsConstructor
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;

    @Override
    public ResponseEntity<HttpStatus> createSeat(SeatDTO seatDTO) {
        seatService.saveSeat(SeatMapper.dtoToSeat(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateSeat(SeatDTO seatDTO) {
        seatService.updateSeat(SeatMapper.dtoToSeat(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSeat(Long id) {
        Seat seat = seatService.getSeatById(id);
        seatService.deleteSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public List<SeatDTO> getAllSeatsOnFlight(Long flightId) {
        List<Seat> seats = seatService.getSeatByFlightId(flightId);
        return seats.stream().map(SeatMapper::seatToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SeatDTO> getSeatsOnFlightByCategory(Long flightId, SeatCategory seatCategory) {
        List<Seat> seats = seatService.getSeatByFlightIdAndCategory(flightId, seatCategory);
        return seats.stream().map(SeatMapper::seatToDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Integer> getNumberOfSoldSeats(Long flightId) {
        return new ResponseEntity<>(seatService.getNumberOfSoldSeats(flightId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfUnsoldSeats(Long flightId) {
        return new ResponseEntity<>(seatService.getNumberOfUnsoldSeats(flightId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfRegisteredPassengersOnFlight(Long flightId) {
        return new ResponseEntity<>(seatService.getNumberOfRegisteredPassengers(flightId), HttpStatus.OK);
    }
}