package ru.kataproject.p_sm_airlines_1.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Сущность Route базыданных
 *
 * @author Toboe512
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //TODO связать с Destination
    @NonNull
    String destinationFrom;

    //TODO связать с Destination
    @NonNull
    String destinationTo;

    @NonNull
    LocalDate departureDate;

    @NonNull
    LocalDate arrivalDate;

    @NonNull
    Integer numberOfSeats;

    //TODO связать с Category
    @NonNull
    String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Route route = (Route) o;
        return id != null && Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
