package com.renta.application.controller;
import com.renta.application.entity.User;
import com.renta.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public User register(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

}