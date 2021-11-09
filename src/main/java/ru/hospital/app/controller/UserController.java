package ru.hospital.app.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import ru.hospital.app.dto.UserDto;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

public interface UserController {
    String getUsersignUpForm();

    String getUserUpdateForm(Model model, UUID id);

    String signUpForUser(UserDto user);

    String getUserInfo(UUID id, Model model);

    String getAllUsers(UUID id, Model model);

    String updateUser(UserDto userDto, UUID id);

    String deleteUser(UUID id);

    List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(Record record, UUID userId);

    List<Appointment> getFutureAppointments(UUID userId);

    List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType);
}
