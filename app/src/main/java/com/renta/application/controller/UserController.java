package com.renta.application.controller;

import com.renta.application.entity.User;
import com.renta.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/manage/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/view/all")
    public List<User> showAllUsers(){
        return userService.findAllUsers();
    }

}
