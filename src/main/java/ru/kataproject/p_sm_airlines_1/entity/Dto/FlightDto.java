package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Value;
import ru.kataproject.p_sm_airlines_1.entity.FlightStatus;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * DTO для работы с сущностью рейса
 *
 * @author Toboe512
 */
@Value
@Schema(description = "DTO of flight")
public class FlightDto {

    @Schema(description = "id", example = "1", type = "Long")
    Long id;
    @NonNull
    @Schema(description = "destination From")
    //TODO связать с сущностью Destination
    String destinationFrom;
    @NonNull
    @Schema(description = "destination To")
    //TODO связать с сущностью Destination
    String destinationTo;
    @NonNull
    @NotEmpty
    @Future
    @Schema(description = "departure Date Time", example = "2022-10-12T17:39:07.474Z", required = true)
    LocalDateTime departureDateTime;
    @NonNull
    @NotEmpty
    @Future
    @Schema(description = "arrival date Time", example = "2022-10-12T17:39:07.474Z", required = true)
    LocalDateTime arrivalDateTime;
    @NonNull
    @Schema(description = "aircraft")
    //TODO связать с сущность Aircraft
    String aircraft;
    @NonNull
    @NotEmpty
    @Schema(description = "flight status", example = "ACCORDING_TO_PLAN", required = true)
    FlightStatus flightStatus;
    @NonNull
    @NotEmpty
    @Schema(description = "flight Services")
    //TODO добавить сущность InflightServices
    String inflightServices;
}
