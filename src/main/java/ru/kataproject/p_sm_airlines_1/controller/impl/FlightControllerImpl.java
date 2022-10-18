package ru.kataproject.p_sm_airlines_1.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.FlightController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDto;
import ru.kataproject.p_sm_airlines_1.entity.Flight;
import ru.kataproject.p_sm_airlines_1.service.FlightService;
import ru.kataproject.p_sm_airlines_1.util.mapper.FlightMapper;

/**
 * Контроллер для обработки запросов по добавлению, изминению и получению данных рейса
 * <p>
 * (C)Toboe512
 */
@RestController
public class FlightControllerImpl implements FlightController {

    private final FlightService flightService;

    public FlightControllerImpl(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Получение рейса по ID
     *
     * @param id идентификатор рейса
     * @return ResponseEntity<FlightDTO>
     */
    @Override
    public ResponseEntity<FlightDto> getFlightById(Long id) {
        FlightDto flight = FlightMapper.mapped(flightService.getFlightById(id));
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    /**
     * Создание рейса
     *
     * @param flight данные рейса
     * @return ResponseEntity<FlightDTO>
     */
    @Override
    public ResponseEntity<FlightDto> createFlight(FlightDto flight) {
        flightService.saveFlight(FlightMapper.mapped(flight));
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    /**
     * Обновление данных по рейсу
     *
     * @param flight данные рейса
     * @return ResponseEntity<FlightDTO>
     */
    @Override
    public ResponseEntity<FlightDto> updateFlight(FlightDto flight) {
        flightService.updateFlight(FlightMapper.mapped(flight));
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    /**
     * Метод уаления рейса по id
     *
     * @param id идентификатор рейса
     * @return ResponseEntity<FlightDTO>
     */
    @Override
    public ResponseEntity<FlightDto> deleteFlightById(Long id) {
        Flight flight = flightService.getFlightById(id);
        flightService.delete(flight);
        return new ResponseEntity<>(FlightMapper.mapped(flight), HttpStatus.OK);
    }

    /**
     * Получение сводобных мест по рейсу
     *
     * @param flight данные рейса
     * @return ResponseEntity<Seats>
     */
    //TODO после добавления Seat доработать
    @Override
    public ResponseEntity<String> getFreeSeatsOnFlight(FlightDto flight) {
        return null;
    }
}
