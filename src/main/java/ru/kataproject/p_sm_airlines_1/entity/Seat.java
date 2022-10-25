package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Seat class represents a seat in an aircraft cabin.
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 07.10.2022
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    /*
    Добавить сущность Aircraft.
    @ManyToOne(mappedBy="aircraft")
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    */
    private String aircraft;
    private String seatNumber;
    private Integer fare;
    private Boolean isRegistered;
    private Boolean isSold;
    private SeatCategory seatCategory;

    public Seat(String aircraft, String seatNumber, Integer fare, @Value("false") Boolean isRegistered, @Value("false") Boolean isSold, SeatCategory seatCategory) {
        this.aircraft = aircraft;
        this.seatNumber = seatNumber;
        this.fare = fare;
        this.isRegistered = isRegistered;
        this.isSold = isSold;
        this.seatCategory = seatCategory;
    }
}