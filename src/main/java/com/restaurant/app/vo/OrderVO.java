package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderVO {

    private Long id;

    //private User user;

    //private Restaurant restaurant;

    private double totalPrice;

    private String status; // PLACED, CONFIRMED, DELIVERED, CANCELLED
}

