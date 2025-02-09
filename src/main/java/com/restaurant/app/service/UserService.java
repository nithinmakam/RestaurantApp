package com.restaurant.app.service;

import java.util.List;

import com.restaurant.app.entity.User;
import com.restaurant.app.vo.UserVO;

public interface UserService {

    UserVO register(UserVO userVo);

    UserVO login(UserVO userVo);

    UserVO getUser(Long id);

    List<UserVO> getUsers();

    UserVO updateUser(Long id, UserVO userVo);

    void deleteUser(Long id);

    void forgotPassword(UserVO userVo);

    void resetPassword(UserVO userVo);

    void verifyEmail(UserVO userVo);

    
    
}
