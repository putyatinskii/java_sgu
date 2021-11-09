package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hospital.app.controller.UserController;
import ru.hospital.app.dto.UserDto;
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
    @GetMapping(value = "/user-sign-up")
    public String getUsersignUpForm() {
        return "userSignUp";
    }

    @Override
    @PostMapping(value = "/user-sign-up")
    public String signUpForUser(@ModelAttribute("userDto") UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/start";
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
    @GetMapping(value = "/user/{id}/update")
    public String getUserUpdateForm(Model model, @PathVariable UUID id) {
        model.addAttribute("id", id);
        return "updateUser";
    }

    @Override
    @GetMapping("/user/{id}/all")
    public String getAllUsers(@PathVariable UUID id, Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        model.addAttribute("id", id);
        return "Users";
    }

    @Override
    @PostMapping("/user/{id}/update")
    public String updateUser(@ModelAttribute("userDto") UserDto userDto, @PathVariable UUID id) {
        try {
            userService.updateUser(userDto, id);
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
            return "redirect:/logout";
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
