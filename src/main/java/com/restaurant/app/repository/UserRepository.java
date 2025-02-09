package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);
    
    User findByEmailAndPassword(String email, String password);
    
    User findByEmailAndRole(String email, String role);
    
    User findByEmailAndEmailVerificationCode(String email, String emailVerificationCode);
    
    User findByEmailAndPasswordResetCode(String email, String passwordResetCode);
    
    User findByEmailAndEmailVerificationCodeAndEmailVerificationExpiryAfter(String email, String emailVerificationCode, Date emailVerificationExpiry);
    
    User findByEmailAndPasswordResetCodeAndPasswordResetExpiryAfter(String email, String passwordResetCode, Date passwordResetExpiry);
    
    User findByEmailAndRoleAndEmailVerificationStatus(String email, String role, String emailVerificationStatus);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCode(String email, String role, String emailVerificationStatus, String emailVerificationCode);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfter(String email, String role, String emailVerificationStatus, String emailVerificationCode, Date emailVerificationExpiry);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfterAndPasswordResetCodeAndPasswordResetExpiryAfter(String email, String role, String emailVerificationStatus, String emailVerificationCode, Date emailVerificationExpiry, String passwordResetCode, Date passwordResetExpiry);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfterAndPasswordResetCodeAndPasswordResetExpiryAfterAndIdNot(String email, String role, String emailVerificationStatus, String emailVerificationCode, Date emailVerificationExpiry, String passwordResetCode, Date passwordResetExpiry, Long id);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfterAndIdNot(String email, String role, String emailVerificationStatus, String emailVerificationCode, Date emailVerificationExpiry, Long id);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfterAndPasswordResetCodeAndPasswordResetExpiryAfterAndIdNot(String email, String role, String emailVerificationStatus, String emailVerificationCode, Date emailVerificationExpiry, String passwordResetCode, Date passwordResetExpiry, Long id);
    
    User findByEmailAndRoleAndEmailVerificationStatusAndEmailVerificationCodeAndEmailVerificationExpiryAfterAndPasswordResetCode
    
}
