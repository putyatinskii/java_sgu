package ru.hospital.app.service;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    void addDoctor(Doctor doctor);

    String checkDoctor(String login, String password);

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment);
}
