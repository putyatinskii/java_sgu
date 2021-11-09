package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "logins")
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue
    private UUID id;

    private String login;

    @OneToOne(mappedBy = "login")
    private User user;

    @OneToOne(mappedBy = "login")
    private Doctor doctor;

    @Override
    public String toString() {
        return login;
    }
}
