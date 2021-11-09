package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hospital.app.dto.DoctorDto;
import ru.hospital.app.model.*;
import ru.hospital.app.model.Record;
import ru.hospital.app.repository.AppointmentRepository;
import ru.hospital.app.repository.DoctorRepository;
import ru.hospital.app.repository.LoginRepository;
import ru.hospital.app.repository.RecordRepository;
import ru.hospital.app.service.DoctorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service("dbDoctorService")
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final RecordRepository recordRepository;

    private final AppointmentRepository appointmentRepository;

    private final LoginRepository loginRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Doctor addDoctor(DoctorDto doctorDto) {
        Login login = new Login(null, doctorDto.getLogin(), null, null);
        Doctor doctor = new Doctor(null,
                login,
                passwordEncoder.encode(doctorDto.getPassword()),
                doctorDto.getName(),
                doctorDto.getNumber(),
                doctorDto.getEmail(),
                doctorDto.getSpeciality(),
                doctorDto.getExperience(),
                null);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorInfo(UUID id) {
        return doctorRepository.getById(id);
    }

    @Override
    public Doctor updateDoctor(DoctorDto doctorDto, UUID id) {
        Doctor doctor = doctorRepository.getById(id);
        if (doctorDto.getPassword() != null && !"".equals(doctorDto.getPassword())) {
            doctor.setPassword(passwordEncoder.encode(doctorDto.getPassword()));
        }
        if (doctorDto.getLogin() != null && !"".equals(doctorDto.getLogin())) {
            Login userLogin = loginRepository.getById(doctor.getLogin().getId());
            userLogin.setLogin(doctorDto.getLogin());
            loginRepository.save(userLogin);
        }
        if (doctorDto.getName() != null && !"".equals(doctorDto.getName())) {
            doctor.setName(doctorDto.getName());
        }
        if (doctorDto.getEmail() != null && !"".equals(doctorDto.getEmail())) {
            doctor.setEmail(doctorDto.getEmail());
        }
        if (doctorDto.getNumber() != null && !"".equals(doctorDto.getNumber())) {
            doctor.setNumber(doctorDto.getNumber());
        }
        if (doctorDto.getExperience() != null && !"".equals(doctorDto.getExperience())) {
            doctor.setExperience(doctorDto.getExperience());
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(UUID id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findByName(String login) {
        Login login1 = loginRepository.getLoginByLogin(login).orElse(null);
        return doctorRepository.findDoctorByLogin(login1).orElse(null);
    }


    @Override
    public void createRecords(UUID doctorId, LocalDateTime dateTime) {
        Record record = recordRepository.save(new Record(null, null, doctorRepository.getById(doctorId), dateTime, null));
        appointmentRepository.save(new Appointment(null, record, "", false, false, false));
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Record> getTodayRecords(UUID doctorId) {
        return recordRepository.findRecordByDoctorIdAndTimeOfAppointment(doctorId, LocalDateTime.now().toLocalDate());
    }

    @Override
    public List<Record> getUserRecords(UUID doctorId, UUID userId) {
        return recordRepository.findRecordByDoctorIdAndUserId(doctorId, userId);
    }
}
