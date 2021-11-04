package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.repository.AppointmentRepository;
import ru.hospital.app.repository.DoctorRepository;
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

    private final PasswordEncoder passwordEncoder;


    @Override
    public Doctor addDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorInfo(UUID id) {
        return doctorRepository.getById(id);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(UUID id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor findByName(String name) {
        return doctorRepository.findDoctorByLogin(name).orElse(null);
    }


    @Override
    public void createRecords(UUID doctorId, LocalDateTime dateTime) {
        Record record = recordRepository.save(new Record(null, null, doctorRepository.getById(doctorId), dateTime, null));
        appointmentRepository.save(new Appointment(null, record, "" , false, false, false));
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
