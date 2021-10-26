package ru.hospital.app.service.impl;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.service.DoctorService;

import java.util.List;
import java.util.UUID;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public String checkDoctor(String login, String password) {
        return null;
    }

    @Override
    public List<Record> getTodayRecords(UUID doctorId) {
        return null;
    }

    @Override
    public List<Record> getUserRecords(UUID doctorId, UUID userId) {
        return null;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }
}
