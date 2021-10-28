package ru.hospital.app.controller;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DoctorController {

    String getDoctorsignUpForm();

    void signUpForDoctor(Doctor doctor);

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment);

    void createRecords(UUID doctorId, LocalDateTime dateTime);
}
