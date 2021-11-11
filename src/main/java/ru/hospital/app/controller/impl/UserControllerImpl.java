package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/user/home")
    public String getUserInfo(Model model) {
        User user = userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("name", user.getName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("phone", user.getNumber());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("id", user.getId());
        return "UserLk";

    }

    @Override
    @GetMapping(value = "/user/home/update")
    public String getUserUpdateForm(Model model) {
        return "updateUser";
    }

    @Override
    @GetMapping("/user/home/all")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "Users";
    }

    @Override
    @PostMapping("/user/home/update")
    public String updateUser(@ModelAttribute("userDto") UserDto userDto) {
        try {
            User user = userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
            userService.updateUser(userDto, user.getId());
            return "redirect:/user/home";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @Override
    @PostMapping("/user/home")
    public String deleteUser() {
        try {
            User user = userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
            userService.deleteUser(user.getId());
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
