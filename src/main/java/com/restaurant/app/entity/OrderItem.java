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
@Table(name = "order_item")
@Getter @Setter
public class OrderItem  extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @JoinColumn(name = "food_item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FoodItem foodItem;
    
    private int quantity;

    private double price;

    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
