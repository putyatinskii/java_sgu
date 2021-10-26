package ru.hospital.app.controller;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;

import java.util.List;
import java.util.UUID;

public interface DoctorController {

    List<Record> getTodayRecords(UUID doctorId);

    List<Record> getUserRecords(UUID doctorId, UUID userId);

    void updateAppointment(Appointment appointment);
}
