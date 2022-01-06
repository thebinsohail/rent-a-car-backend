package com.renta.application.service;

import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;


    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /* for saving the User */

    public User saveUser(User user){

        Optional<User> findByEmail=userRepository.findByEmail(user.getEmail());

        if(findByEmail.isPresent()){
            throw new RuntimeException("User Already exists with the email "+user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

       /* for finding out the user */

        public User findUser(User user) {
            Optional<User> findByEmail=userRepository.findByEmail(user.getEmail());

            if(findByEmail.isPresent()){
                return user;
            }
            else
                throw new UsernameNotFoundException("User does not exists with this email!");
        }

        //TODO: find all

        public List<User> findAllUsers(){

           return userRepository.findAll();

        }

        //TODO: forgot password



}