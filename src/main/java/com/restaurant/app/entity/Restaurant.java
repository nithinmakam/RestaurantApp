package com.restaurant.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Getter @Setter
public class Restaurant  extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private String description;

    private String phoneNo;

    @Column(columnDefinition="TEXT")
    private String address;

    private double rating;
}
