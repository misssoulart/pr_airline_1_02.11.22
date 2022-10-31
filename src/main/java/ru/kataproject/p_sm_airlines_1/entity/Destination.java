package ru.kataproject.p_sm_airlines_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "timezone")
    private int timezone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destination that = (Destination) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(countryCode, that.countryCode)) return false;
        if (!Objects.equals(countryName, that.countryName)) return false;
        if (!Objects.equals(airportName, that.airportName)) return false;
        if (!Objects.equals(airportCode, that.airportCode)) return false;
        return Objects.equals(timezone, that.timezone);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (airportName != null ? airportName.hashCode() : 0);
        result = 31 * result + (airportCode != null ? airportCode.hashCode() : 0);
        result = 31 * result + timezone;
        return result;
    }
}