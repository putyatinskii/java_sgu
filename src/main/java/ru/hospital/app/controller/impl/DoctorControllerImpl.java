package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hospital.app.controller.DoctorController;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.service.DoctorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DoctorControllerImpl implements DoctorController {

    private final DoctorService doctorService;

    @Override
    @GetMapping(value = "/doctor-sign-up")
    public String getDoctorsignUpForm(Model model) {
        model.addAttribute("speciality", Arrays.asList(Speciality.values()));
        return "doctorSignUp";
    }

    @Override
    @PostMapping(value = "/doctor-sign-up")
    public String signUpForDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/start";
    }

    @Override
    public String getDoctorUpdateForm() {
        return null;
    }

    @Override
    public String getDoctorInfo(UUID id, Model model) {
        return null;
    }

    @Override
    public String getAllDoctors(UUID id, Model model) {
        return null;
    }

    @Override
    public List<Record> getTodayRecords(UUID doctorId) {
        return null;
    }

    @Override
    public List<Record> getUserRecords(UUID doctorId, UUID userId) {
        return null;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void createRecords(UUID doctorId, LocalDateTime dateTime) {

    }
}
