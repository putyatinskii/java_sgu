package ru.hospital.app.service;

import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void addUser(User user);

    String checkUser(String login, String password);

    Record checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(Record record);

    List<Record> getFutureRecords(UUID userId);

    List<Record> getPastRecords(UUID userId, String doctorName, Speciality doctorType);

}
