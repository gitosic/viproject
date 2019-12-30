package com.vebinar.dao;

import com.vebinar.entity.User;
import com.vebinar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Класс который будет реализовывать методы из класса UserDao
@Repository
public class UserDaoImpl implements UserDao{

    public final JdbcTemplate jdbcTemplate;
    //Анатация Autowired подключает этот объект который описан ранее.
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO vebinar.user (name, email, age) VALUES (?, ?, ?)";
        String sql2 = "INSERT INTO user (name, email, age) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM vebinar.user WHERE id = ?";
        String sql2 = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE vebinar.user SET name = ?, email = ?, age = ? WHERE id = ?;";
        String sqlExample = "UPDATE vebinar.user SET name = 'value1', email = 'value2', age = 1 WHERE id = 3;";
        String sql2 = "UPDATE user SET name=?, email=?, age=?, WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vebinar.user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    //findAll - должен залезть в бд и достать оттуда всех юзеров
    @Override
    public List<User> findAll() {
        //String sql = "SELECT * FROM user";
        String sql = "SELECT * FROM vebinar.user";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
