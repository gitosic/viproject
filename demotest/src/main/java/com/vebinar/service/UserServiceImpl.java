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
}
