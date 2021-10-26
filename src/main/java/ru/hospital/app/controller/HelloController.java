package ru.hospital.app.controller;


import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Role;
import ru.hospital.app.model.User;


public interface HelloController {

    void signUpForUser(User user);

    void signUpForDoctor(Doctor doctor);

    void signIn(String login, String password, Role role);
}
