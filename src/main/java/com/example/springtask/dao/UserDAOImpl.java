package com.example.springtask.dao;

import com.example.springtask.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> userQuery =
                currentSession.createQuery("from User",
                        User.class);

        List<User> users = userQuery.getResultList();

        return users;
    }

    @Override
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(user);

    }

    @Override
    public User getUser(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        User user = currentSession.get(User.class, userId);

        return user;
    }

    @Override
    public void deleteUser(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from User where id=:userId");
        query.setParameter("userId", userId);

        query.executeUpdate();

    }
}
