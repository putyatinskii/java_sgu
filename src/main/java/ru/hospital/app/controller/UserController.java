package ru.hospital.app.controller;

import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;

import java.util.List;
import java.util.UUID;

public interface UserController {

    Record CheckFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(Record record);

    List<Record> getFutureRecords(UUID userId);

    List<Record> getPastRecords(UUID userId, String doctorName, Speciality doctorType);
}
