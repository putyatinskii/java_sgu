package ru.hospital.app.service;

import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    void addUser(User user);

    User checkUser(String login, String password) throws Exception;

    List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(Record record, UUID userId) throws Exception;

    List<Appointment> getFutureAppointments(UUID userId);

    List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType);

}
