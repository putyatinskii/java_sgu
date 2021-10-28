package ru.hospital.app.controller;

import org.springframework.ui.Model;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

public interface UserController {
    String getUsersignUpForm();

    String getUserUpdateForm();

    String signUpForUser(User user);

    String getUserInfo(UUID id, Model model);

    String getAllUsers(UUID id, Model model);

    String updateUser(User user, UUID id);

    String deleteUser(UUID id);

    List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(Record record, UUID userId);

    List<Appointment> getFutureAppointments(UUID userId);

    List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType);
}
