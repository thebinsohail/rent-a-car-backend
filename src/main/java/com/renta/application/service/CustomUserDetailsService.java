package com.renta.application.service;

import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

       Optional<User> user=userRepository.findByUserName(userName);

       if(user.isPresent()){
           return user.map(CustomDetails::new).get();
       }
        else
            throw new UsernameNotFoundException("User "+user.get().getUserName()+" not found!");
    }
}
