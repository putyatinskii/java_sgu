package ru.hospital.app.service.impl;

import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;
import ru.hospital.app.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {

    }

    @Override
    public String checkUser(String login, String password) {
        return null;
    }

    @Override
    public Record checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
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
