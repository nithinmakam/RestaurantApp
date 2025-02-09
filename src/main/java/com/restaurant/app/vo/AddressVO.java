package com.restaurant.app.vo;

import com.restaurant.app.entity.Address;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Data
@Builder
public class AddressVO {

    private Long id;
    
    private String receiverName;
    
    private String receiverPhoneNo;
    
    private String type; // HOME, WORK, OTHER
    
    private String flatBuilNo;
    
    private String addressLine1;
    
    private String addressLine2;
    
    private String landmark;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String pincode;

    private String message;

    public AddressVO fromEntity(Address address) {
        return AddressVO.builder()
                .id(address.getId())
                .receiverName(address.getReceiverName())
                .receiverPhoneNo(address.getReceiverPhoneNo())
                .type(address.getType())
                .flatBuilNo(address.getFlatBuilNo())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .landmark(address.getLandmark())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .build();
    }
    
}
