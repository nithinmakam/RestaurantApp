package com.restaurant.app.service;

import org.springframework.stereotype.Service;

import com.restaurant.app.entity.User;
import com.restaurant.app.vo.AddressVO;

@Service
public interface AddressService {

    AddressVO saveAddress(AddressVO address, User user) ;    
}
