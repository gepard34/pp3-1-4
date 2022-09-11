package ru.kata.spring.boot_security.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleService.save(role1);
        roleService.save(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();
        roleAdmin.add(role1);
        roleUser.add(role2);
        User user1 = new User("nikita@mail.ru", "nikita", "grakov", "admin", roleAdmin);
        User user2 = new User("dima@mail.ru", "dima", "dima", "user", roleUser);

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
