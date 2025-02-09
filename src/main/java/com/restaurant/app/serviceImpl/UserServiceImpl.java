package com.restaurant.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import com.restaurant.app.entity.User;
import com.restaurant.app.repository.UserRepository;
import com.restaurant.app.service.UserService;
import com.restaurant.app.vo.UserVO;

public abstract class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserVO register(UserVO userVo) {
        User user = User.toUser(userVo);
        user.setEmailVerificationStatus("PENDING");
        user.setPassword(passwordEncoder.encode(userVo.getPassword()));
        user = userRepository.save(user);

        userVo.setId(user.getId());
        userVo.setEmailVerificationStatus(user.getEmailVerificationStatus());
        userVo.setMessage("User registered successfully. Please verify your email to login.");
        return userVo;
    }
}
