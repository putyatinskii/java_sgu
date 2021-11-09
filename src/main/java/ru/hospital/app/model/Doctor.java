package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    private String password;

    private String name;

    private String number;

    private String email;

    private Speciality speciality;

    private String experience;

    @OneToMany(mappedBy = "doctor")
    private List<Record> records;

    @Override
    public String toString() {
        return "Doctor{" +
                "login=" + login +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", speciality=" + speciality +
                ", experience='" + experience + '\'' +
                '}';
    }
}
