package ru.hospital.app.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class AppointmentTestRepository {
    @Getter
    private List<Appointment> appointmentList = new ArrayList<>();

    public void add(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public void update(Appointment appointmentUpdate) throws Exception {
        Appointment appointment1 = appointmentList
                .stream()
                .filter(appointment -> appointment.getRecord().getId().equals(appointmentUpdate.getRecord().getId()))
                .findFirst().orElseThrow(Exception::new);
        if (appointment1 != null) {
            appointment1.setRecord(appointmentUpdate.getRecord());
            appointment1.setDescription(appointmentUpdate.getDescription());
            appointment1.setIsClosed(appointmentUpdate.getIsClosed());
            appointment1.setIsSick(appointmentUpdate.getIsSick());
            appointment1.setIsVisit(appointmentUpdate.getIsVisit());
        }
    }

    public List<Appointment> getAppointmentByPredicate(Predicate<Appointment> predicate) {
        return appointmentList.stream().filter(predicate).collect(Collectors.toList());
    }
}
