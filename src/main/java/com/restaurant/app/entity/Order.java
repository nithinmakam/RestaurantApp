package com.restaurant.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order  extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "restaurant_id")
    @ManyToOne
    private Restaurant restaurant;

    private double totalPrice;

    private String status; // PLACED, CONFIRMED, DELIVERED, CANCELLED
}

