package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserById(int id);
    List<User> allUsers();
    boolean saveUser(User user);
    void edit(int id, User user);

    public void delete(int id);

}
