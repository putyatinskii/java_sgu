package ru.hospital.app.repository;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Speciality;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class DoctorTestRepository {
    @Getter
    private List<Doctor> doctorList = new ArrayList<>();

    public void add(Doctor doctor) {
        doctor.setId(UUID.randomUUID());
        doctorList.add(doctor);
    }

    public Optional<Doctor> contains(String login, String password) {
        return doctorList
                .stream()
                .filter(doctor -> doctor.getLogin().equals(login) &&
                        doctor.getPassword().equals(password))
                .findFirst();
    }

    public Optional<Doctor> get(UUID id) {
        return doctorList
                .stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst();
    }

    public List<Doctor> getByPredicate(Predicate<Doctor> predicate) {
        return doctorList.stream().filter(predicate).collect(Collectors.toList());
    }
}
