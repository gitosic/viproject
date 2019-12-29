package com.vebinar.service;

import com.vebinar.entity.User;

import java.util.List;

//Логика работы
public interface UserService {

    List<User> findAll();

    //Изначально лежало в UserDao
    void save(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);
}
