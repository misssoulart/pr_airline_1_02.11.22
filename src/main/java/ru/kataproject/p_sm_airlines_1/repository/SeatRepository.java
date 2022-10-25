package ru.kataproject.p_sm_airlines_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import org.springframework.stereotype.Repository;

/**
 * Implements Seat DAO via Spring Data JPA.
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 07.10.2022
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
