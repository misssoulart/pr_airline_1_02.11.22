package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO of destination")
public class DestinationDTO {
    @NotNull
    @Schema(description = "ID of destination")
    private Long id;

    @NotNull
    @Schema(description = "city of destination")
    private String city;

    @NotNull
    @Schema(description = "country code of destination")
    private String countryCode;

    @NotNull
    @Schema(description = "country name of destination")
    private String countryName;

    @NotNull
    @Schema(description = "airport name of destination")
    private String airportName;

    @NotNull
    @Schema(description = "airport code of destination")
    private String airportCode;

    @NotNull
    @Schema(description = "timezone of destination")
    private int timezone;
}