package ru.hospital.app.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ru.hospital.app.model.User;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserTestRepository {
    @Getter
    private List<User> userList = new ArrayList<>();

    public User add(User user) {
        user.setId(UUID.randomUUID());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        userList.add(user);
        return user;
    }

    public User update(User user) throws Exception {
        User user1 = userList
                .stream()
                .filter(user2 -> user2.getId().equals(user.getId()))
                .findFirst()
                .orElseThrow(Exception::new);
        if (user1!= null) {
            user1.setLogin(user.getLogin());
            user1.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setNumber(user.getNumber());
        }
        return user1;
    }

    public void deleteUser(UUID id) throws Exception {
        userList.remove(userList.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(Exception::new));
    }

    public Optional<User> contains(String login, String password) {
        return userList
                .stream()
                .filter(user -> user.getLogin().equals(login) &&
                        user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8))))
                .findFirst();
    }

    public Optional<User> get(UUID userId) {
        return userList.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }
}
