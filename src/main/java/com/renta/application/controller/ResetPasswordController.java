package com.renta.application.controller;
import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import com.renta.application.resetPassword.ResetPassword;
import com.renta.application.service.EmailService;
import com.renta.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/v1/user")
public class ResetPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public ResetPasswordController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    Random random=new Random(1000);
    int randomOTP;

    @PostMapping("/forgot-password")
    public String sendOTP(@RequestParam(name = "email") String email){
        int OTP=random.nextInt(9999);
        randomOTP=OTP;
        System.out.println("OTP:"+OTP);
        // TODO:send OTP using MailSender
        emailService.sendEmail("Renta - Password Reset",email,"OTP CODE:"+OTP);
        return "Email was sent successfully to "+email;
    }

    @PostMapping("/verify-otp")
    public boolean verifyOTP(@RequestParam(name ="otp") String otp){
        if(Integer.parseInt(otp)==randomOTP)
            return true;

        return false;
    }

    /* If OTP is verified then call this function */

    @PutMapping("/reset-password")
    public String resetPassword(@RequestBody ResetPassword resetPassword) {

          Optional<User> user=userRepository.findByEmail(resetPassword.getEmail());

          if(user.isPresent()){
              User customer=user.get();
              customer.setPassword(passwordEncoder.encode(resetPassword.getNewPassword()));
              return "Your password was reset";
          }

          return "There was a problem";

    }

}
