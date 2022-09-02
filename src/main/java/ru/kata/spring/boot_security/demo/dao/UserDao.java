package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void edit(User user);
    void delete(int id);
    User getUser(int id);
    List<User> index();
    User findByUsername (String username);
}
