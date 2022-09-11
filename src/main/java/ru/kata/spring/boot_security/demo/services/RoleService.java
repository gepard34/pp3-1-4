package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role getRoleById(int id);
    Role getRoleByRoleName(String name);
    void save(Role role);
    void update( Role updatedRole);
    void delete(int id);
    List<Role> getDemandedRoles();
}
