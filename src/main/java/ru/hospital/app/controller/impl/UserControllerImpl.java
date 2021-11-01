package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hospital.app.controller.UserController;
import ru.hospital.app.model.Appointment;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.Speciality;
import ru.hospital.app.model.User;
import ru.hospital.app.service.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @GetMapping(value = "/user")
    public String getUsersignUpForm() {
        return "userSignUp";
    }

    @Override
    @GetMapping(value = "/user/{id}/update")
    public String getUserUpdateForm() {
        return "updateUser";
    }

    @Override
    @PostMapping(value = "/user")
    public String signUpForUser(@ModelAttribute("user") User user) {
            userService.addUser(user);
            return "start";
    }

    @Override
    @GetMapping("/user/{id}")
    public String getUserInfo(@PathVariable UUID id, Model model) {

        User user = userService.getUserInfo(id);
        model.addAttribute("name", user.getName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("phone", user.getNumber());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("id", user.getId());
        return "UserLk";

    }

    @Override
    @GetMapping("/user/{id}/all")
    public String getAllUsers(@PathVariable UUID id, Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        model.addAttribute("id", id);
        return "list";
    }

    @Override
    @PostMapping("/user/{id}/update")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable UUID id) {
        user.setId(id);
        try {
            userService.updateUser(user);
            return "redirect:/user/" + id;
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @Override
    @PostMapping("/user/{id}")
    public String deleteUser(@PathVariable UUID id) {
        try {
            userService.deleteUser(id);
            return "redirect:/start";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    @Override
    public void createRecord(Record record, UUID userId) {

    }

    @Override
    @RequestMapping()
    public List<Record> checkFreeTime(String doctorName, Speciality doctorType, Integer period) {
        return null;
    }

    @Override
    public List<Appointment> getFutureAppointments(UUID userId) {
        return null;
    }

    @Override
    public List<Appointment> getPastAppointments(UUID userId, String doctorName, Speciality doctorType) {
        return null;
    }
}
