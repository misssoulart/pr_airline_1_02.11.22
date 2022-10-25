package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;
import ru.kataproject.p_sm_airlines_1.entity.Seat;

/**
 * Converting the Seat class to the DTO class and vice versa.
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 13.10.2022
 */
public class SeatMapper {

    public static Seat dtoToSeat(SeatDTO seatDTO) {
        return new Seat(seatDTO.getId(),
                seatDTO.getAircraft(),
                seatDTO.getSeatNumber(),
                seatDTO.getFare(),
                seatDTO.getIsRegistered(),
                seatDTO.getIsSold(),
                seatDTO.getSeatCategory());
    }

    public static SeatDTO seatToDTO(Seat seat) {
        return new SeatDTO(seat.getId(),
                seat.getAircraft(),
                seat.getSeatNumber(),
                seat.getFare(),
                seat.getIsRegistered(),
                seat.getIsSold(),
                seat.getSeatCategory());
    }
}
