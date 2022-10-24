package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDto;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;

public class PassengerMapper {

    public static Passenger dtoToEntity(PassengerDto passengerDto) {
        return new Passenger()
                .setId(passengerDto.getId())
                .setFirstName(passengerDto.getFirstName())
                .setMiddleName(passengerDto.getMiddleName())
                .setLastName(passengerDto.getLastName())
                .setDateOfBirth(passengerDto.getDateOfBirth())
                .setUsername(passengerDto.getUsername())
                .setPassword(passengerDto.getPassword())
                .setMobileNumber(passengerDto.getMobileNumber())
                .setNickName(passengerDto.getNickName());
    }

    public static PassengerDto entityToDto(Passenger passenger) {
        return new PassengerDto()
                .setId(passenger.getId())
                .setFirstName(passenger.getFirstName())
                .setMiddleName(passenger.getMiddleName())
                .setLastName(passenger.getLastName())
                .setDateOfBirth(passenger.getDateOfBirth())
                .setUsername(passenger.getUsername())
                .setPassword(passenger.getPassword())
                .setMobileNumber(passenger.getMobileNumber());
    }

}
