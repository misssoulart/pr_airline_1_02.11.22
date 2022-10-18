package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDto;
import ru.kataproject.p_sm_airlines_1.entity.Flight;


/**
 * Преобзарование сущность Flight в DTO и обратно
 *
 * @author Toboe512
 */
public class FlightMapper {
    public static Flight mapped(FlightDto flightDTO) {
        return new Flight(flightDTO.getId(),
                flightDTO.getDestinationFrom(),
                flightDTO.getDestinationTo(),
                flightDTO.getDepartureDateTime(),
                flightDTO.getArrivalDateTime(),
                flightDTO.getAircraft(),
                flightDTO.getFlightStatus(),
                flightDTO.getInflightServices());
    }

    public static FlightDto mapped(Flight flight) {
        return new FlightDto(flight.getId(),
                flight.getDestinationFrom(),
                flight.getDestinationTo(),
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getAircraft(),
                flight.getFlightStatus(),
                flight.getInflightServices());
    }
}
