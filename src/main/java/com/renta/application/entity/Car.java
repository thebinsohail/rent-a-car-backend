package com.renta.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_model")
    private int model;
    @Column(name = "car_color")
    private String color;


    @OneToOne(cascade = CascadeType.ALL)
    Order order;

}















