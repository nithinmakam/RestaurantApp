package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemVO {

    private Long id;

    //private FoodItem foodItem;
    
    private int quantity;

    private double price;

    //private Order order;
}
