package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Сущность рейса
 * (C)Toboe512
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    // @ManyToOne
    // @JoinColumn(name = "destination_from", referencedColumnName = "id")
    //TODO связать с сущностью Destination
    private String destinationFrom;
    @NonNull
    // @ManyToOne
    // @JoinColumn(name = "destination_to", referencedColumnName = "id")
    //TODO связать с сущностью Destination
    private String destinationTo;
    @NonNull
    @NotEmpty
    private LocalDateTime departureDateTime;
    @NonNull
    @NotEmpty
    private LocalDateTime arrivalDateTime;
    @NonNull
    // @ManyToOne
    // @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    //TODO связать с сущность Aircraft
    private String aircraft;
    @NonNull
    @NotEmpty
    private FlightStatus flightStatus;
    @NonNull
    @NotEmpty
    //TODO
    private String inflightServices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id) && destinationFrom.equals(flight.destinationFrom)
                && destinationTo.equals(flight.destinationTo)
                && departureDateTime.equals(flight.departureDateTime)
                && arrivalDateTime.equals(flight.arrivalDateTime)
                && aircraft.equals(flight.aircraft)
                && flightStatus == flight.flightStatus
                && inflightServices.equals(flight.inflightServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinationFrom,
                destinationTo, departureDateTime,
                arrivalDateTime, aircraft,
                flightStatus, inflightServices);
    }
}
