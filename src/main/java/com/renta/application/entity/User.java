package com.renta.application.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "full_name")
    private String fullName;
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