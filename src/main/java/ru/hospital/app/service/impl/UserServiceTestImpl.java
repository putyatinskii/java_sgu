package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;
import ru.hospital.app.repository.AppointmentTestRepository;
import ru.hospital.app.repository.RecordsTestRepository;
import ru.hospital.app.repository.UserTestRepository;
import ru.hospital.app.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Component("testUserService")
@RequiredArgsConstructor
public class UserServiceTestImpl implements UserService {

    private final UserTestRepository userTestRepository;

    private final RecordsTestRepository recordsTestRepository;

    private final AppointmentTestRepository appointmentTestRepository;

    @Override
    public void addUser(User user) {
        userTestRepository.add(user);
    }

    @Override
    public User checkUser(String login, String password) throws Exception {
        return userTestRepository.contains(login, password).orElseThrow(Exception::new);
    }

    @Override
    public List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        Predicate<Record> predicate = record -> record.getUser() == null &&
                record.getTimeOfAppointment().isBefore(LocalDateTime.now().plusDays(period));
        if (doctorName != null) {
            predicate = predicate.and(record -> record.getDoctor().getName().equals(doctorName));
        } else if (doctorType != null) {
            predicate = predicate.and(record -> record.getDoctor().getSpeciality().equals(doctorType));
        }
        return recordsTestRepository.getRecordsByPredicate(predicate);
    }

    @Override
    public void createRecord(Record record, UUID userId) throws Exception {
        record.setUser(userTestRepository.get(userId).orElseThrow(Exception::new));
        recordsTestRepository.add(record);
        appointmentTestRepository.add(new Appointment(record, "", false, false, false));
    }

    @Override
    public List<Appointment> getFutureAppointments(UUID userId) {
        Predicate<Appointment> predicate = appointment -> appointment.getRecord().getUser().getId().equals(userId) &&
                appointment.getIsClosed().equals(false);
        return appointmentTestRepository.getAppointmentByPredicate(predicate);
    }

    @Override
    public List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType) {
        Predicate<Appointment> predicate = appointment -> appointment.getRecord().getUser().getId().equals(userId) &&
                appointment.getIsClosed().equals(true);
        if (doctorName != null) {
            predicate = predicate.and(appointment -> appointment.getRecord().getDoctor().getName().equals(doctorName));
        } else if (doctorType != null){
            predicate = predicate.and(appointment -> appointment.getRecord().getDoctor().getSpeciality().equals(doctorType));
        }
        return appointmentTestRepository.getAppointmentByPredicate(predicate);
    }
}
