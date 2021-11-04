package ru.hospital.app.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

//    @Query("Select appointments from appointments inner join records on records.id = appointments.id\n" +
//            "where user_id=:user_id and is_closed = true")
//    List<Appointment> findAppointmentByUserAndIsClosedTrue(@Param("user_id") UUID userId);
//
//    List<Appointment> findAppointmentByUserAndIsClosedFalse(UUID userId);
//
//    List<Appointment> findAppointmentByUserAndDoctorNameAndIsClosedFalse(UUID userId, String doctorName);
//
//    List<Appointment> findAppointmentByUserIdAndDoctorSpecialityAndIsClosedFalse(UUID userId, Integer doctorSpeciality);
}
