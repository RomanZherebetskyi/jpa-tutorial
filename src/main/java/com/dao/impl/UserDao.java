package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dao.IUserDao;

import com.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List findAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
