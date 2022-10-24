package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for communication with the Passenger (client).
 * Describe here the fields that come from the client to the server (and from the server to the client).
 * N.B! The Team decided that the Entity = DTO in the first phase of development.
 * @Schema - description for front developers (swagger)
 */
@Getter
@Setter
@Accessors(chain = true)
public class PassengerDto {

    @Id
    @Schema(description = "Идентификатор пассажира. Unique identifier, AI, generated automatically in the data base")
    Long id;

    @NotEmpty(message = "First Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Schema(description = "Обязательное поле, аналогично документу. Required field, mark write similar to the document")
    String firstName;

    @Schema(description = "Не обязательно для заполнения. Optional field, mark write similar to the document")
    String middleName;

    @NotEmpty(message = "Last Name should not be empty")
    @Size(min = 2, max = 30, message = "Last Name should be between 2 and 30 characters")
    @Schema(description = "Обязательное поле, аналогично документу. Required field, mark write similar to the document")
    String lastName;

    @NotEmpty(message = "Date of birth should not be empty")
    @Schema(description = "Дата рождения по формату. Date of birth format: YYYY-MM-DD (choose from the calendar)")
    LocalDate dateOfBirth;

    @Email
    @NotEmpty(message = "Email should not be empty")
    @Schema(description = "Обязательное поле, аутентификация, авторизация, коммуникация после покупки билета." +
           " Required field, show email entry example (authentication and authorization in the personal account)." +
           " The client chooses one of the methods of communication after ordering a ticket (check-box)")
    String username;

    @NotEmpty
    @Schema(description = "Шифруем, храним в базе, внутренняя инфо. Encrypt and store in the DB, internal info +" +
            " (authentication and authorization in the personal account)")
    String password;

    @NotEmpty(message = "Mobile Number should not be empty")
    @Schema(description = "Опционально. Данные нужны, если клиент выбирете канал этот коммуникации. Проверка формата." +
            " Optional field, show mobile phone entry example." +
            " The client chooses one of the methods of communication after ordering a ticket (check-box)")
    String mobileNumber;

    @Schema(description = "Опционально. Данные нужны, если клиент выбирете канал этот коммуникации. Проверка формата." +
            " Optional field, show data entry @example" +
            " The client chooses one of the methods of communication after ordering a ticket (check-box)")
    String nickName;

}
