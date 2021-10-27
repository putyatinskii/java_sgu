package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String login;
    private String password;
    private String name;
    private String number;
    private String email;
    private Date birthdayDate;

}
