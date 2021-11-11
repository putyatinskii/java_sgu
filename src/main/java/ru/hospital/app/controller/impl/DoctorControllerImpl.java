package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hospital.app.controller.DoctorController;
import ru.hospital.app.dto.DoctorDto;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.service.DoctorService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

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
    public String signUpForDoctor(@ModelAttribute("doctorDto") DoctorDto doctorDto) {
        doctorService.addDoctor(doctorDto);
        return "redirect:/start";
    }

    @Override
    @GetMapping(value = "/doctor/home/update")
    public String getDoctorUpdateForm() {
        return "updateDoctor";
    }

    @Override
    @GetMapping("/doctor/home")
    public String getDoctorInfo(Model model) {
        Doctor doctor = doctorService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("name", doctor.getName());
        model.addAttribute("login", doctor.getLogin());
        model.addAttribute("phone", doctor.getNumber());
        model.addAttribute("email", doctor.getEmail());
        model.addAttribute("speciality", doctor.getSpeciality().getSpeciality());
        model.addAttribute("experience", doctor.getExperience());
        model.addAttribute("id", doctor.getId());
        return "DoctorLk";
    }

    @Override
    @GetMapping("/doctor/home/all")
    public String getAllDoctors(Model model) {
        List<Doctor> list = doctorService.getAllDoctors();
        model.addAttribute("list", list);
        return "Doctors";
    }

    @Override
    @PostMapping("/doctor/home/update")
    public String updateDoctor(@ModelAttribute("doctorDto") DoctorDto doctorDto) {
        try {
            Doctor doctor = doctorService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
            doctorService.updateDoctor(doctorDto, doctor.getId());
            return "redirect:/doctor/home";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @Override
    @PostMapping("doctor/home")
    public String deleteDoctor() {
        try {
            Doctor doctor = doctorService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
            doctorService.deleteDoctor(doctor.getId());
            return "redirect:/logout";
        } catch (Exception e) {
            return "redirect:/error";
        }
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
