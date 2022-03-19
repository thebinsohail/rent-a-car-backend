package com.renta.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date",nullable = false)
    private Date orderDate;
    @Column(name = "pickup_address")
    private String pickupAddress;
    @Column(name = "droppff_address")
    private String dropOffAddress;


    @PrePersist
    private void onCreate() {
        orderDate = new Date();
    }


}
