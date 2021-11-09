package ru.hospital.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hospital.app.model.Login;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String login;

    private String password;

    private String name;

    private String number;

    private String email;
}
