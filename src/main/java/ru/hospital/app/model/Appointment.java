package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Record record;
    private String description;
    private Boolean isSick;
    private Boolean isClosed;
    private Boolean isVisit;
}
