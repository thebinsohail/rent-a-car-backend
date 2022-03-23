package com.renta.application.service;

import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService {

    private String emailAddress;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* for saving the User */

    public User saveUser(User user){

        Optional<User> findByEmail=userRepository.findByEmail(user.getEmail());
        if(findByEmail.isPresent()){
            throw new RuntimeException("User Already exists with the email "+user.getEmail());
        }

        // encrypting the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // saving it to the database using JPA
        userRepository.save(user);
       // emailService.sendEmail("Renta Registration", user.getEmail(), "Your account was registered with email "+user.getEmail()+"\n"+ "Dated: "+LocalDate.now()+"\n"+ "Time: "+LocalTime.now());

        return user;
    }




       /* for finding out the user for login */

        public User findUser(String userName,String password) throws UnknownHostException {
            Optional<User> user=userRepository.findByUserName(userName);
            boolean passwordExists=passwordEncoder.matches(password,user.get().getPassword());

            if(user.isPresent() && passwordExists){
                String email=user.get().getEmail();
               // emailService.sendEmail("Renta Login Alert", email, "Login Attempt with IP: \n"+ InetAddress.getLocalHost().getHostAddress() +"\n"+"Host Device: \n"+InetAddress.getLocalHost().getHostName()+"\nDate and Time:\n"+ LocalDate.now()+"\n"+ LocalTime.now());
                return user.get();
            }
            else
                throw new UsernameNotFoundException("User "+userName+" does not exists");
        }

        public List<User> findAllUsers(){

           return userRepository.findAll();

        }



}