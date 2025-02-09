package com.restaurant.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_category")
@Getter @Setter
public class ItemCategory  extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_category_id")
    private Long id;

    private String categoryName;

    private String categoryDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    
}
