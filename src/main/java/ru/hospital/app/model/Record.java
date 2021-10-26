package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Record {
    private UUID id;
    private UUID userId;
    private UUID dictorId;
    private LocalDateTime timeOfAppointment;
}
