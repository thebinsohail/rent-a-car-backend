package com.renta.application.controller;
import com.renta.application.entity.User;
import com.renta.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(path = "api/v1/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    InetAddress inetAddress;
    Logger logger=LoggerFactory.getLogger(RegistrationController.class);

    @PostMapping("/register")
    public User register(@RequestBody User user) throws UnknownHostException {
        userService.saveUser(user);
        logger.warn("Registration Attempt!");
        return user;
    }
}