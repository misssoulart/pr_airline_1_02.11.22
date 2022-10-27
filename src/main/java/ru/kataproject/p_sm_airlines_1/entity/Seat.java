package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;
}