package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.repository.AppointmentTestRepository;
import ru.hospital.app.repository.DoctorTestRepository;
import ru.hospital.app.repository.RecordsTestRepository;
import ru.hospital.app.service.DoctorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Component("testDoctorService")
public class DoctorServiceTestImpl implements DoctorService {

    private final DoctorTestRepository doctorTestRepository;

    private final RecordsTestRepository recordsTestRepository;

    private final AppointmentTestRepository appointmentTestRepository;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorTestRepository.add(doctor);
    }

    @Override
    public Doctor checkDoctor(String login, String password) throws Exception {
        return doctorTestRepository.contains(login, password).orElseThrow(Exception::new);
    }

    @Override
    public List<Record> getTodayRecords(UUID doctorId) {
        Predicate<Record> predicate = record -> record.getDoctor().getId().equals(doctorId) &&
                LocalDate.from(record.getTimeOfAppointment()).equals(LocalDate.now());
        return recordsTestRepository.getRecordsByPredicate(predicate);
    }

    @Override
    public List<Record> getUserRecords(UUID doctorId, UUID userId) {
        Predicate<Record> predicate = record -> record.getDoctor().getId().equals(doctorId) &&
                record.getUser().getId().equals(userId);
        return recordsTestRepository.getRecordsByPredicate(predicate);
    }

    @Override
    public void updateAppointment(Appointment appointment) throws Exception {
        appointmentTestRepository.update(appointment);
    }

    @Override
    public void createRecords(UUID doctorId, LocalDateTime dateTime) throws Exception {
        Doctor doctor = doctorTestRepository.get(doctorId).orElseThrow(Exception::new);
        recordsTestRepository.add(new Record(UUID.randomUUID(), null, doctor, dateTime));
    }
}
