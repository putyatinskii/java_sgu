package ru.hospital.app.controller;


import org.springframework.ui.Model;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface HelloController {

    String start();

    String errorPage();

    String getsignInForm();

    String signIn(HttpServletRequest request);
}
