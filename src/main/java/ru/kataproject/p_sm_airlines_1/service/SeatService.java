package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.SeatCategory;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import java.util.List;

/**
 * Declares Seat Service API.
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 07.10.2022
 */
public interface SeatService {

    /**
     * This method returns a seat by id.
     *
     * @param id Long
     * @return Seat
     */
    Seat getSeatById(Long id);

    /**
     * This method creates a new seat.
     *
     * @param seat Seat
     */
    void saveSeat(Seat seat);

    /**
     * This method updates the seat.
     *
     * @param seat Seat
     */
    void updateSeat(Seat seat);

    /**
     * This method deletes the seat.
     *
     * @param seat Seat
     */
    void deleteSeat(Seat seat);

    /**
     * This method returns all seats on the flight by Flight id.
     *
     * @param flightId Long
     * @return List<Seat>
     */
    List<Seat> getSeatByFlightId(Long flightId);

    /**
     * This method returns all seats of a certain category on a flight by Flight id & Seat category.
     *
     * @param flightId Long
     * @param seatCategory SeatCategory
     * @return List<Seat>
     */
    List<Seat> getSeatByFlightIdAndCategory(Long flightId, SeatCategory seatCategory);

    /**
     * This method returns a number of sold seats on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    int getNumberOfSoldSeats(Long flightId);

    /**
     * This method returns a number of unsold seats on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    int getNumberOfUnsoldSeats(Long flightId);

    /**
     * This method returns a number of registered passengers on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    int getNumberOfRegisteredPassengers(Long flightId);
}