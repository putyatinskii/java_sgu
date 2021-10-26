package ru.hospital.app.controller.impl;

import ru.hospital.app.controller.DoctorController;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;

import java.util.List;
import java.util.UUID;

public class DoctorControllerImpl implements DoctorController {

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
