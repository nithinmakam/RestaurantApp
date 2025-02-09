package com.restaurant.app.entity;

import com.restaurant.app.vo.AddressVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends Audit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
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
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean active;

    public static Address fromVo(AddressVO addressVO) {
        return Address.builder()
                .receiverName(addressVO.getReceiverName())
                .receiverPhoneNo(addressVO.getReceiverPhoneNo())
                .type(addressVO.getType())
                .flatBuilNo(addressVO.getFlatBuilNo())
                .addressLine1(addressVO.getAddressLine1())
                .addressLine2(addressVO.getAddressLine2())
                .landmark(addressVO.getLandmark())
                .city(addressVO.getCity())
                .state(addressVO.getState())
                .country(addressVO.getCountry())
                .pincode(addressVO.getPincode())
                .active(true)
                .build();
    }
}
