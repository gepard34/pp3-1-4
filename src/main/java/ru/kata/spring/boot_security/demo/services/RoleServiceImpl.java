package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;


    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByRoleName(String name) {
        return roleDao.getRoleByRoleName(name);
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }


    @Override
    public void update( Role updatedRole) {
        roleDao.update(updatedRole);
    }


    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> getDemandedRoles() {
        return roleDao.getDemandedRoles();
    }
}
