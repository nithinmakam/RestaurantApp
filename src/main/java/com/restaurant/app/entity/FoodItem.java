package com.restaurant.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_item")
@Getter @Setter
public class FoodItem  extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id")
    private Long id;

    private String itemName;

    private String itemDescription;

    private double itemPrice;

    @Column(columnDefinition="TEXT")
    private String itemImage;

    private int itemRating;

    private String foodCategory; // VEG, NON-VEG

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_category_id")
    private ItemCategory category;
    
}
