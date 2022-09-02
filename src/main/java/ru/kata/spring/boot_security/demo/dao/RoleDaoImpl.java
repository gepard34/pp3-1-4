package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r from Role r", Role.class).getResultList();
    }

    public Role getRoleById (int id) {
        return entityManager.find(Role.class, id);
    }

    public Role findRoleByName(String name) {
        return entityManager.createQuery("SELECT r from Role r where r.name = :name", Role.class).setParameter("name", name)
                .getSingleResult();
    }

    public Set<Role> getRolesById (List<Integer> roles) {
        TypedQuery<Role> roleTypedQuery = entityManager.createQuery("select r from Role r where r.id in :role", Role.class);
        roleTypedQuery.setParameter("role", roles);
        return new HashSet<>(roleTypedQuery.getResultList());
    }
}
