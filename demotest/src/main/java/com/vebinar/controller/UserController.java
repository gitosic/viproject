package com.vebinar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
Будет работ с веб прил, будет обрабатывать нащи запросы с темплейтом
 */

//Что бы поймать hello.ftl на странице http://localhost:8080/hello
@RequestMapping//Будет обрабатывать маппинг начиная со слеша --> /
@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello(){//Сделаем метод, который обрабатывает гет запрос по адресу hello
        //String это название темплейта которое мы создали во views
        return "hello";
    }
}

