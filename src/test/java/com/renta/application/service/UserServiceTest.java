package com.renta.application.service;
import static org.mockito.Mockito.verify;
import com.renta.application.entity.User;
import com.renta.application.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    /* Fake instance of userRepo class for testing */
    @Mock
    UserRepository userRepository;

    UserService userService;

    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp(){
        this.userService=new UserService(this.userRepository);
        this.passwordEncoder=new BCryptPasswordEncoder();
    }


    @Test
    void saveUserTest() {
        User user=
                new User(1L,"mrwick","johnwick","USER", "12345678", "mrwick@email.com","12345678");

        userService.saveUser(user);
        verify(userRepository).save(user);

    }

    @Test
    void findUserTest(){
        String userName="abdallah";
        String password="addi";

        userService.findUser(userName,password);

        verify(userRepository).findByUserNameAndAndPassword(userName,password);
    }

    @Test
    void findAllUsersTest() {

        userService.findAllUsers();
        verify(userRepository).findAll();
    }
}