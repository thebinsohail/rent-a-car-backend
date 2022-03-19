package com.renta.application.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_role")
    private String role;

    @NotNull
    @Column(name = "user_password")
    private String password;
    @NotNull
    @Column(name = "user_email")
    private String email;
    @NotNull
    @Column(name = "user_phone")
    private String phone;


}