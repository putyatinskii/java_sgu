package ru.hospital.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    User addUser(User user);

    User findByName(String name);

    User getUserInfo(UUID id);

    List<User> getAllUsers();

    User updateUser(User user) throws Exception;

    void deleteUser(UUID id) throws Exception;

    List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period);

    void createRecord(UUID recordId, UUID userId) throws Exception;

    List<Appointment> getFutureAppointments(UUID userId);

    List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType);

}
