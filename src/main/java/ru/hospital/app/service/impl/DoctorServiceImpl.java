package ru.hospital.app.service.impl;

import org.springframework.stereotype.Component;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.service.DoctorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class DoctorServiceImpl implements DoctorService {

    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public Doctor checkDoctor(String login, String password) throws Exception {
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

    @Override
    public void createRecords(UUID doctorId, LocalDateTime dateTime) throws Exception {

    }
}
