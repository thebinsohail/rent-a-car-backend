package com.renta.application.controller;
import com.renta.application.dto.EmailDto;
import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import com.renta.application.dto.ResetPassword;
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

    @PostMapping("/forgot-password/")
    public String sendOTP( EmailDto email){
        int OTP=random.nextInt(9999);
        randomOTP=OTP;
        System.out.println("OTP:"+OTP);
        Optional<User> user=userRepository.findByEmail(email.getEmailAddress().toString());
        if(user.isPresent()){
            emailService.sendEmail("Renta - Password Reset", String.valueOf(email),"Your OTP code for password reset: "+OTP);
            return "Email was sent successfully to "+email;
        }


        return "User with email "+email+" does not exists!";
        
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

          return "There was a problem resetting your password!";

    }

}
