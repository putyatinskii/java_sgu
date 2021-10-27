package ru.hospital.app.service;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DoctorService {
    void addDoctor(Doctor doctor);

    Doctor checkDoctor(String login, String password) throws Exception;

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment) throws Exception;

    void createRecords(UUID doctorId, LocalDateTime dateTime) throws Exception;
}
