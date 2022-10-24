package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.time.LocalDate;

/**
 * Description of the entity in the PassengerReadme.md
 */

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate dateOfBirth;

    @Email
    @Column(name = "email")
    private String username;

    @Column
    private String password;

    @Column(name = "mobile_num")
    private String mobileNumber;

    @Column(name = "nick_name")
    private String nickName;

}
