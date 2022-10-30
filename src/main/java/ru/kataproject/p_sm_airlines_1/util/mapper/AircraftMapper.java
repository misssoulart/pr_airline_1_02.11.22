package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;

/**
 * Преобзарование сущность Aircraft в DTO и обратно
 */

public class AircraftMapper {
    public static Aircraft mapped(AircraftDto aircraftDto) {
        return new Aircraft(aircraftDto.getId(),
                aircraftDto.getOnBoardNumber(),
                aircraftDto.getStamp(),
                aircraftDto.getModel(),
                aircraftDto.getYearOfRelease(),
                aircraftDto.getSeat());
    }
    public static AircraftDto mapped(Aircraft aircraft) {
        return new AircraftDto(aircraft.getId(),
                aircraft.getOnBoardNumber(),
                aircraft.getStamp(),
                aircraft.getModel(),
                aircraft.getYearOfRelease(),
                aircraft.getSeat());
    }
}
