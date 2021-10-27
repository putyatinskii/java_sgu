package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private UUID id;
    private User user;
    private Doctor doctor;
    private LocalDateTime timeOfAppointment;
}
