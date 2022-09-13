package ru.kata.spring.boot_security.demo.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AdminController {
    private UserService userService;
    private RoleService roleService;


    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.showUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.showById(id), HttpStatus.OK);
    }



    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    @PatchMapping("/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable("id") int id) {
        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @GetMapping("/roles")
    ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getDemandedRoles(), HttpStatus.OK);
    }



}
