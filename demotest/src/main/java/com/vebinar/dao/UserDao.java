package com.vebinar.dao;

import com.vebinar.entity.User;

import java.util.List;

/*
Опишем который опишет как мы будем работать с базой данных
 */
//Работа с бд
public interface UserDao {

    //Создание юзера
    void save(User user);

    //Получение данных из бд, зная только id
    User getById(int id);

    //Обновление данных юзера
    void update(User user);

    //Удаление пользователя, зная только id
    void delete(int id);

    List<User> findAll();
}
