package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private  UserDao userDAO;
    private RoleService roleService;
    private ApplicationContext context;

    public UserServiceImpl(UserDao userDAO, RoleService roleService, ApplicationContext context) {
        this.userDAO = userDAO;
        this.roleService = roleService;
        this.context = context;
    }


    @Override
    public List<User> showUsers() {
        return userDAO.showUsers();
    }

    @Override
    public User showById(long id) {
        return userDAO.showById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        setEncryptedPassword(user);
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        setEncryptedPassword(updatedUser);
        userDAO.update(id, updatedUser);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }


    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }


    @Override
    public User setRolesToUser(User user, int[] rolesIdArr) {
        List<Role> userRoles = new ArrayList<>();
        if (rolesIdArr != null) {
            for (int i : rolesIdArr) {
                userRoles.add(roleService.getRoleById(i));
            }
        }
        user.setRoles(userRoles);
        return user;
    }

    @Override
    public void setEncryptedPassword(User user) {
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }


}
