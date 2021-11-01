package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="doctors")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue
    private UUID id;

    private String login;

    private String password;

    private String name;

    private String number;

    private String email;

    private Speciality speciality;

    private String experience;

    @OneToMany(mappedBy = "doctor")
    private List<Record> records;
}
