package com.restaurant.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.app.entity.Address;
import com.restaurant.app.entity.User;
import com.restaurant.app.repository.AddressRepository;
import com.restaurant.app.service.AddressService;
import com.restaurant.app.vo.AddressVO;

public abstract class AddressServiceImpl implements AddressService {

    @Autowired 
    private AddressRepository addressRepository;

    @Override
    public AddressVO saveAddress(AddressVO addressVo, User user) {
        final Address address = Address.fromVo(addressVo);
        address.setActive(true);
        address.setUser(user);
        addressRepository.save(address);
        addressVo.setId(address.getId());
        addressVo.setMessage("Address saved successfully");
        return addressVo;
    }
    
}
