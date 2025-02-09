package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RestaurantVO {

    private Long id;

    private String name;

    private String description;

    private String phoneNo;

    private String address;

    private double rating;
}
