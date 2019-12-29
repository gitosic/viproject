package com.vebinar.controller;

import com.vebinar.entity.User;
import com.vebinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    //Данные через гет передатся в url-нике
    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    //Созд темплейт создания нового юзера
    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    //Добавим форму добавления нового юзера
    //Данные передаются в невидемом виде в response и body
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    //Обновление юзера
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    //Делаем апдейт
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    //Делаем удаление
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}

