package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(value = "/doctor/{id}/update")
    public String getDoctorUpdateForm(Model model, @PathVariable UUID id) {
        model.addAttribute("id", id);
        return "updateDoctor";
    }

    @Override
    @GetMapping("/doctor/{id}")
    public String getDoctorInfo(@PathVariable UUID id, Model model) {
        Doctor doctor = doctorService.getDoctorInfo(id);
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
    @GetMapping("/doctor/{id}/all")
    public String getAllDoctors(@PathVariable UUID id, Model model) {
        List<Doctor> list = doctorService.getAllDoctors();
        model.addAttribute("list", list);
        model.addAttribute("id", id);
        return "Doctors";
    }

    @Override
    @PostMapping("/doctor/{id}/update")
    public String updateDoctor(@ModelAttribute("doctorDto") DoctorDto doctorDto, @PathVariable UUID id) {
        try {
            doctorService.updateDoctor(doctorDto, id);
            return "redirect:/doctor/" + id;
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @Override
    @PostMapping("doctor/{id}")
    public String deleteDoctor(@PathVariable UUID id) {
        try {
            doctorService.deleteDoctor(id);
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
