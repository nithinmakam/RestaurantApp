package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodItemVO {

    private Long id;

    private String itemName;

    private String itemDescription;

    private double itemPrice;

    private String itemImage;

    private int itemRating;

    private String foodCategory; // VEG, NON-VEG
}
