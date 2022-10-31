package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;

import java.util.List;
import java.util.stream.Collectors;
//Destination to TDO mapper

public class DestinationMapper {
    public static DestinationDTO toDTO(Destination destination) {
        return new DestinationDTO(destination.getId(),
                destination.getCity(),
                destination.getCountryCode(),
                destination.getCountryName(),
                destination.getAirportName(),
                destination.getAirportCode(),
                destination.getTimezone());
    }

    public static List<DestinationDTO> toDTOs(List<Destination> destinationList) {
        return destinationList.stream().map(DestinationMapper::toDTO).collect(Collectors.toList());
    }
}