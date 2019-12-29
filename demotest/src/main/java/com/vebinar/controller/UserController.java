package com.vebinar.controller;

import com.vebinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
Будет работ с веб прил, будет обрабатывать нащи запросы с темплейтом
 */

//Что бы поймать hello.ftl на странице http://localhost:8080/hello
@RequestMapping//Будет обрабатывать маппинг начиная со слеша --> /
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";//Переименовали index.html в index.ftl и добавили вот этот гетМаппинп для этой странице
    }

    @GetMapping("/hello")
    public String hello(){//Сделаем метод, который обрабатывает гет запрос по адресу hello
        //String это название темплейта которое мы создали во views
        return "hello";
    }

    //Model - это грубо говоря мапа которая нужна для передачи данных между view и контроллером
    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }
}

