package com.renta.application.repository;


import com.renta.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameAndAndPassword(String userName,String password);
    Optional<User> findByUserName(String userName);
}