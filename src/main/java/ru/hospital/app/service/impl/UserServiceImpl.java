package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hospital.app.dto.UserDto;
import ru.hospital.app.model.*;
import ru.hospital.app.model.Record;
import ru.hospital.app.repository.AppointmentRepository;
import ru.hospital.app.repository.LoginRepository;
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

    private final LoginRepository loginRepository;

    @Override
    public User addUser(UserDto userDto) {
        Login login = new Login(null, userDto.getLogin(), null, null);
        User user = new User(null,
                login,
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getName(),
                userDto.getNumber(),
                userDto.getEmail(),
                null);
        return userRepository.save(user);
    }

    @Override
    public User findByName(String login) {
        Login login1 = loginRepository.getLoginByLogin(login).orElse(null);
        return userRepository.findUserByLogin(login1).orElse(null);
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
    public User updateUser(UserDto userDto, UUID id) {
        User user = userRepository.getById(id);
        if (userDto.getPassword() != null && !"".equals(userDto.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        if (userDto.getName() != null && !"".equals(userDto.getName())) {
            user.setName(userDto.getName());
        }
        if (userDto.getEmail() != null && !"".equals(userDto.getEmail())) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getNumber() != null && !"".equals(userDto.getNumber())) {
            user.setNumber(userDto.getNumber());
        }
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
}
