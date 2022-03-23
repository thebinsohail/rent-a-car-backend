package com.renta.application.controller;

import com.renta.application.dto.LoginDetails;
import com.renta.application.entity.User;
import com.renta.application.service.EmailService;
import com.renta.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class LoginController {

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    // TODO: Login authentication
    @PostMapping(value = "/login", consumes = "application/json")
    public User loginUser(@RequestBody LoginDetails loginDetails) throws UnknownHostException {
        User user=userService.findUser(loginDetails.getUserName(),loginDetails.getPassword());
        return user;
    }

}
