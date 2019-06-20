package com.dao;

import com.entity.User;

import java.util.List;


public interface IUserDao {

    void insertUser(User user);

    List findAllUsers();

}
