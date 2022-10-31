package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.repository.DestinationRepository;
import ru.kataproject.p_sm_airlines_1.service.DestinationService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.SeatNotFoundException;
import ru.kataproject.p_sm_airlines_1.repository.SeatRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kataproject.p_sm_airlines_1.entity.SeatCategory;
import ru.kataproject.p_sm_airlines_1.service.SeatService;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

/**
 * Implements SeatService interface.
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 07.10.2022
 */
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;

    @Override
    public Seat getSeatById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.orElseThrow(SeatNotFoundException::new);
    }

    @Override
    @Transactional
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    @Transactional
    public void updateSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    @Transactional
    public void deleteSeat(Seat seat) {
        seatRepository.delete(seat);
    }

    @Override
    public List<Seat> getSeatByFlightId(Long flightId) {
        return null;
    }

    @Override
    public int getNumberOfSoldSeats(Long flightId) {
        return 0;
    }

    @Override
    public int getNumberOfUnsoldSeats(Long flightId) {
        return 0;
    }

    @Override
    public List<Seat> getSeatByFlightIdAndCategory(Long flightId, SeatCategory seatCategory) {
        return null;
    }

    @Override
    public int getNumberOfRegisteredPassengers(Long flightId) {
        return 0;
    }

    @Service
    @Transactional(readOnly = true)
    public static class DestinationServiceImpl implements DestinationService {

        private final DestinationRepository destinationRepository;

        public DestinationServiceImpl(DestinationRepository destinationRepository) {
            this.destinationRepository = destinationRepository;
        }
        @Transactional
        @Override
        public void create(Destination destination) {
            destinationRepository.saveAndFlush(destination);
        }

        @Override
        public Destination getById(Long id) {
            return destinationRepository.findById(id).get();
        }

        @Transactional
        @Override
        public void update(Destination destination) {
            destinationRepository.saveAndFlush(destination);
        }

        @Override
        public void deleteById(Long id) {
            destinationRepository.deleteById(id);
        }
        @Transactional
        @Override
        public List<Destination> getByCity(String city) {
            return destinationRepository.getByCity(city);
        }
        @Transactional
        @Override
        public List<Destination> getByCountry(String countryName) {
            return destinationRepository.getByCountry(countryName);
        }
    }
}
