package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Doctor {
    private UUID id;
    private String login;
    private String password;
    private String name;
    private String number;
    private String email;
    private Date birthdayDate;
    private Speciality speciality;
    private String experience;
}
