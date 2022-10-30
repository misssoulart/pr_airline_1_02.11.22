package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Сущность Aircraft
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotEmpty
    @Column(name = "on_board_number")
    private String onBoardNumber;  // бортовой номер

    @NonNull
    @NotEmpty
    private String stamp; // марка

    @NonNull
    @NotEmpty
    @Column(name = "model", unique = true, nullable = false)
    private String model;

    @NonNull
    @NotEmpty
    @Column(name = "year_of_release")
    private int yearOfRelease; // год выпуска

    @NonNull
    @NotEmpty
    private long seat;

}
