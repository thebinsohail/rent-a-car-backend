package com.renta.application.service;

import com.renta.application.entity.Car;
import com.renta.application.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Car saveCarOrder(Car car){
        carRepository.save(car);
        return car;
    }



}
