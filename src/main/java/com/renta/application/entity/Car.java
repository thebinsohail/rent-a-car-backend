package com.renta.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "model_year")
    private int modelYear;
    // car picture
    @Lob
    @Column(name = "car_pic")
    private Byte [] image;


}
