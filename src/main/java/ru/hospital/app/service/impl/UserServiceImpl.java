package ru.hospital.app.service.impl;

import org.springframework.stereotype.Component;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;
import ru.hospital.app.service.UserService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {

    }

    @Override
    public User checkUser(String login, String password) throws Exception {
        return null;
    }

    @Override
    public List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        return null;
    }

    @Override
    public void createRecord(Record record, UUID userId) {

    }

    @Override
    public List<Appointment> getFutureAppointments(UUID userId) {
        return null;
    }

    @Override
    public List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType) {
        return null;
    }
}
