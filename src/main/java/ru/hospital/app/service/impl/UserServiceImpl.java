package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hospital.app.model.*;
import ru.hospital.app.model.Record;
import ru.hospital.app.repository.AppointmentRepository;
import ru.hospital.app.repository.RecordRepository;
import ru.hospital.app.repository.UserRepository;
import ru.hospital.app.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service("dbUserService")
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AppointmentRepository appointmentRepository;

    private final RecordRepository recordRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByName(String login) {
        return userRepository.findUserByLogin(login).orElse(null);
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        if (doctorName != null) {
            return recordRepository.findRecordByDoctorNameAndUserIsNullAndTimeOfAppointmentBefore(doctorName, LocalDateTime.now().plusDays(period));
        } else if (doctorType != null) {
            return recordRepository.findRecordByDoctorSpecialityAndUserIsNullAndTimeOfAppointmentBefore(doctorType, LocalDateTime.now().plusDays(period));
        } else {
            return recordRepository.findRecordByUserIsNullAndTimeOfAppointmentBefore(LocalDateTime.now().plusDays(period));
        }
    }

    @Override
    public void createRecord(UUID recordId, UUID userId) {
        Record record = recordRepository.getById(recordId);
        record.setUser(userRepository.getById(userId));
        recordRepository.save(record);
    }

    @Override
    public List<Appointment> getFutureAppointments(UUID userId) {
        return null;//appointmentRepository.findAppointmentByUserAndIsClosedTrue(userId);
    }

    @Override
    public List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType) {
//        if (doctorName != null) {
//            return appointmentRepository.findAppointmentByUserAndDoctorNameAndIsClosedFalse(userId, doctorName);
//        } else if (doctorType != null){
//            return appointmentRepository.findAppointmentByUserIdAndDoctorSpecialityAndIsClosedFalse(userId, doctorType.ordinal());
//        } else {
//            return appointmentRepository.findAppointmentByUserAndIsClosedFalse(userId);
//        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                List.of(Role.USER)
        );
    }
}
