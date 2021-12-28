package com.renta.application.controller;

import com.renta.application.entity.User;
import com.renta.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Boolean register(@RequestBody User user){
        userService.findUser(user);
        return false;
    }


}
