package com.restaurant.app.entity;


import java.sql.Date;

import com.restaurant.app.vo.UserVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class User  extends Audit {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    
    private String email;
    
    private String password;
    
    private String role; // ADMIN, CUSTOMER, RESTAURANT_OWNER
    
    private Date dob;
    
    private String gender; // MALE, FEMALE
    
    private String phone;
    
    @Column(columnDefinition="TEXT")
    private String profileImage;
    
    private String emailVerificationStatus; // VERIFIED, PENDING, REJECTED
    
    private String emailVerificationCode;
    
    private String emailVerificationExpiry;
    
    private String passwordResetCode;

    public static User toUser(UserVO userVo) {
        return User.builder()
                .id(userVo.getId())
                .name(userVo.getName())
                .email(userVo.getEmail())
                .phone(userVo.getPhone())
                .role(userVo.getRole())
                .dob(userVo.getDob())
                .gender(userVo.getGender())
                .profileImage(userVo.getProfileImage())
                //.role(userVo.getRole())
                .build();
    }
}
