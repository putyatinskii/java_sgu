package ru.hospital.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hospital.app.model.Login;
import ru.hospital.app.model.Speciality;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {
    private String login;

    private String password;

    private String name;

    private String number;

    private String email;

    private Speciality speciality;

    private String experience;
}
