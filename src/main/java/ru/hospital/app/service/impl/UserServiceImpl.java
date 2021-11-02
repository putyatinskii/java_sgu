package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;
import ru.hospital.app.repository.AppointmentRepository;
import ru.hospital.app.repository.RecordRepository;
import ru.hospital.app.repository.UserRepository;
import ru.hospital.app.service.UserService;

import java.util.List;
import java.util.UUID;

@Service("dbUserService")
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AppointmentRepository appointmentRepository;

    private final RecordRepository recordRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserInfo(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User checkUser(String login, String password) throws Exception {
        return userRepository.findByloginAndPassword(login, password).orElseThrow(Exception::new);
    }

    @Override
    public List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        return null;
    }

    @Override
    public void createRecord(Record record, UUID userId) {
        record.setUser(userRepository.getById(userId));
        recordRepository.save(record);
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
