package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataproject.p_sm_airlines_1.entity.Flight;
import ru.kataproject.p_sm_airlines_1.repository.FlightRepository;
import ru.kataproject.p_sm_airlines_1.service.FlightService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.FlightNotFoundException;

import java.util.Optional;

/**
 * Сервис для работы с бизнеслогикой рейса
 *
 * @author Toboe512
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Transactional
    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Transactional
    @Override
    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Flight getFlightById(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight.orElseThrow(FlightNotFoundException::new);
    }

    @Override
    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }
}
