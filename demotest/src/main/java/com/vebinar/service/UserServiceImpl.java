package com.vebinar.service;

import com.vebinar.dao.UserDao;
import com.vebinar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) throws Exception {
        //todo Добавляем валидацию
        if (user.getName().length() > 20){
            throw new Exception("Максимальная длина имени: 20 символов");
        }
        userDao.save(user);
    }

    @Override//Напишем темплате на getById
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
