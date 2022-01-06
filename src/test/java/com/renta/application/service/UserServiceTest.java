//package com.renta.application.service;
//import static org.mockito.Mockito.verify;
//import com.renta.application.entity.User;
//import com.renta.application.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    /* Fake instance of userRepo class for testing */
//    @Mock
//    UserRepository userRepository;
//
//    UserService userService;
//
//    @BeforeEach
//    void setUp(){
//        this.userService=new UserService(this.userRepository);
//    }
//
//
//    @Test
//    void saveUserTest() {
//        User user=new User(1L, "Anas Bin Sohail",
//                "12345678", "anasbinsohail@outlook.com", "0332566452");
//        userService.saveUser(user);
//        verify(userRepository).save(user);
//
//    }
//
//    @Test
//    void findAllUsersTest() {
//
//        userService.findAllUsers();
//        verify(userRepository).findAll();
//    }
//}