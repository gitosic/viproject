package com.vebinar.dao;

import com.vebinar.entity.User;
import com.vebinar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//Класс который будет реализовывать методы из класса UserDao
public class UserDaoImpl implements UserDao{

    public final JdbcTemplate jdbcTemplate;
    //Анатация Autowired подключает этот объект который описан ранее.
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    //findAll - должен залезть в бд и достать оттуда всех юзеров
    @Override
    public List<User> findAll() {
        //String sql = "SELECT * FROM user";
        String sql = "SELECT * FROM vebinar.user";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
