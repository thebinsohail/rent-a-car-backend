//package com.renta.application.repository;
//
//import com.renta.application.entity.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserRepositoryTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    void isUserExists(){
//
//        // creating a new user to save in db
//        User user=new User(1L, "Anas Bin Sohail",
//                "12345678", "anasbinsohail@outlook.com", "0332566452");
//
//        // saving to db
//        userRepository.save(user);
//
//        // checking if it is saved or not
//        Boolean actualResult=userRepository.existsById(1L);
//
//        //results
//        assertEquals(true,actualResult);
//
//    }
//
//    // deleting the object after our test completes
////    @AfterEach
////    void tearDown(){
////        userRepository.deleteAll();
////    }
//
//}