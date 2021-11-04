package ru.hospital.app.controller;

import org.springframework.ui.Model;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DoctorController {

    String getDoctorsignUpForm(Model model);

    String signUpForDoctor(Doctor doctor);

    String getDoctorUpdateForm();

    String getDoctorInfo(UUID id, Model model);

    String getAllDoctors(UUID id, Model model);

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment);

    void createRecords(UUID doctorId, LocalDateTime dateTime);
}
