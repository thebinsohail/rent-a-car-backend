package com.renta.application.service;

import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import org.slf4j.LoggerFactory;
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

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }




       /* for finding out the user */
        public User findUser(String userName,String password) {
            Optional<User> user=userRepository.findByUserName(userName);
            boolean passwordExists=passwordEncoder.matches(password,user.get().getPassword());

            if(user.isPresent() && passwordExists){
                return user.get();
            }
            else
                throw new UsernameNotFoundException("User "+userName+" does not exists");
        }

        public List<User> findAllUsers(){

           return userRepository.findAll();

        }

        //TODO: forgot password



}