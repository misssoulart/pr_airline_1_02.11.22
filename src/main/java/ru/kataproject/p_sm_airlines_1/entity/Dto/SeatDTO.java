package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.Value;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import ru.kataproject.p_sm_airlines_1.entity.SeatCategory;

/**
 * Seat DTO
 *
 * @author Romanov Leonid (romanovsparta@ya.ru)
 * @since 12.10.2022
 */
@Value
@Schema(description = "Seat's DTO")
public class SeatDTO {
    @Schema(description = "Seat id", example = "1", type = "Long")
    Long id;
    @NotNull
    @Schema(description = "Aircraft", type = "Aircraft")
    //TODO сущность Aircraft пока отсутствует
    String aircraft;
    @NotNull
    @NotEmpty
    @Schema(description = "Number of seat", example = "4A", required = true, type = "String")
    String seatNumber;
    @Schema(description = "Seat fare", example = "123", type = "Integer")
    Integer fare;
    @NotNull
    @NotEmpty
    @Schema(description = "Is seat registered?", example = "false", required = true, type = "Boolean")
    Boolean isRegistered;
    @NotNull
    @NotEmpty
    @Schema(description = "Is seat sold?", example = "false", required = true, type = "Boolean")
    Boolean isSold;
    @NotNull
    @NotEmpty
    @Schema(description = "Seat category", example = "ECONOMY", required = true, type = "Enum")
    SeatCategory seatCategory;
}
