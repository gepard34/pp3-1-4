package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void create(User user) { //addUser
        entityManager.persist(user);
    }


    public void edit(User user) { //UpdateUser
        entityManager.merge(user);
    }


    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }


    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }


    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User findByUsername (String username) {
        return entityManager.createQuery("SELECT u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
