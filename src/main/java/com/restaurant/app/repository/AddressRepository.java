package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.Address;

import lombok.NonNull;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address save(@NonNull Address address);

}
