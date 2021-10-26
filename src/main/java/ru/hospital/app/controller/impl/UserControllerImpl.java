package ru.hospital.app.controller.impl;

import ru.hospital.app.controller.UserController;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;

import java.util.List;
import java.util.UUID;

public class UserControllerImpl implements UserController {
    @Override
    public Record CheckFreeTime(String doctorName, Speciality doctorType, Integer period) {
        return null;
    }

    @Override
    public void createRecord(Record record) {

    }

    @Override
    public List<Record> getFutureRecords(UUID userId) {
        return null;
    }

    @Override
    public List<Record> getPastRecords(UUID userId, String doctorName, Speciality doctorType) {
        return null;
    }
}
