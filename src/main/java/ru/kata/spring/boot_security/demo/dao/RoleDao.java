package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleById (int id);
    Role findRoleByName(String name);
    Set<Role> getRolesById (List<Integer> roles);
}
