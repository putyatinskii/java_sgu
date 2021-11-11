package ru.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.Login;
import ru.hospital.app.model.Role;
import ru.hospital.app.model.User;
import ru.hospital.app.repository.DoctorRepository;
import ru.hospital.app.repository.LoginRepository;
import ru.hospital.app.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final DoctorRepository doctorRepository;

    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Login login1 = loginRepository.getLoginByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
        User user = userRepository.findUserByLogin(login1).orElse(null);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin().getLogin(),
                    user.getPassword(),
                    List.of(Role.USER)
            );
        } else {
            Doctor doctor = doctorRepository.findDoctorByLogin(login1).orElseThrow(() -> new UsernameNotFoundException(login));
            return new org.springframework.security.core.userdetails.User(
                    doctor.getLogin().getLogin(),
                    doctor.getPassword(),
                    List.of(Role.DOCTOR)
            );
        }
    }
}
