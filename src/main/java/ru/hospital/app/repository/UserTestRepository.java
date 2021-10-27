package ru.hospital.app.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ru.hospital.app.model.Doctor;
import ru.hospital.app.model.User;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserTestRepository {
    @Getter
    private List<User> userList = new ArrayList<>();

    public void add(User user) {
        user.setId(UUID.randomUUID());
        userList.add(user);
    }

    public Optional<User> contains(String login, String password) {
        return userList
                .stream()
                .filter(user -> user.getLogin().equals(login) &&
                        user.getPassword().equals(password))
                .findFirst();
    }

    public Optional<User> get(UUID userId) {
        return userList.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }
}
