package com.restaurant.app.vo;

import java.sql.Date;

import com.restaurant.app.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UserVO {
    
    private Long id;

    private String name;
    
    private String email;
    
    private String password;
    
    private String role; // ADMIN, CUSTOMER, RESTAURANT_OWNER
    
    private Date dob;
    
    private String gender; // MALE, FEMALE
    
    private String phone;
    
    private String profileImage;
    
    private String emailVerificationStatus; // VERIFIED, PENDING, REJECTED
    
    private String emailVerificationCode;
    
    private String emailVerificationExpiry;
    
    private String passwordResetCode;

    private String message;

    public static UserVO fromEntity(User user) {
        return UserVO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .dob(user.getDob())
                .gender(user.getGender())
                .phone(user.getPhone())
                .profileImage(user.getProfileImage())
                //.role(user.getRole())
                .build();
    }
}
