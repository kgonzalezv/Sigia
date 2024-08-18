package com.ltp.sigia.service;

import com.ltp.sigia.model.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<User> getUser(String username, String passoword) {
        String query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
       return entityManager.createQuery(query, User.class).setParameter("username", username)
               .setParameter("password", passoword).getResultStream().findAny();
    }
}
