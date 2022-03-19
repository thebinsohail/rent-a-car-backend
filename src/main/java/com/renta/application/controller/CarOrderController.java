package com.renta.application.controller;

import com.renta.application.entity.Car;
import com.renta.application.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user/car/order")
public class CarOrderController {

    @Autowired
    CarService carService;

    Logger logger=LoggerFactory.getLogger(CarOrderController.class);

    @PostMapping
    public Car orderCar(@RequestBody Car carDetails){
        carService.saveCarOrder(carDetails);
        logger.info("Car was ordered successfully!");
        return carDetails;
    }

}
