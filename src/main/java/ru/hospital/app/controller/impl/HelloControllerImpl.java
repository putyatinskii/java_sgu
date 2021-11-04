package ru.hospital.app.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hospital.app.controller.HelloController;
import ru.hospital.app.model.User;
import ru.hospital.app.service.DoctorService;
import ru.hospital.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class HelloControllerImpl implements HelloController {

    private final UserService userService;

    @Override
    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @Override
    @GetMapping(value = "/sign-in")
    public String getsignInForm() {
        return "signIn";
    }

    @Override
    @GetMapping(value = "/error")
    public String errorPage() {
        return "errorPage";
    }
}
