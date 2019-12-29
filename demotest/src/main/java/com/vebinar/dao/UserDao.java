package com.vebinar.dao;

import com.vebinar.entity.User;

import java.util.List;

/*
Опишем который опишет как мы будем работать с базой данных
 */
//Работа с бд
public interface UserDao {

    List<User> findAll();
}
