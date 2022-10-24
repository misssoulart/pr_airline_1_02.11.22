package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
@Schema(description = "DTO of route")
public class RouteDto {
    @Schema(description = "id", example = "1", type = "Long")
    Long id;

    @Schema(description = "destination From")
    @NonNull
    //TODO связать с Destination
    String destinationFrom;

    @NonNull
    @Schema(description = "destination to")
    //TODO связать с Destination
    String destinationTo;

    @NonNull
    @Schema(description = "departure date")
    LocalDate departureDate;

    @NonNull
    @Schema(description = "arrival date")
    LocalDate arrivalDate;

    @NonNull
    @Schema(description = "number of seats")
    Integer numberOfSeats;

    @NonNull
    //TODO связать с Category
    String category;
}
