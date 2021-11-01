package ru.hospital.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="records")
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name="time_of_appointment")
    private LocalDateTime timeOfAppointment;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Appointment appointment;
}
