package ru.hospital.app.service;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);

    Doctor getDoctorInfo(UUID id) throws Exception;

    Doctor updateDoctor(Doctor doctor) throws Exception;

    void deleteDoctor(UUID id) throws Exception;

    Doctor findByName(String name);

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment) throws Exception;

    void createRecords(UUID doctorId, LocalDateTime dateTime) throws Exception;
}
