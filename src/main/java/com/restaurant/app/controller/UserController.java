package com.restaurant.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.entity.User;
import com.restaurant.app.service.UserService;
import com.restaurant.app.vo.UserVO;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserVO> register(@RequestBody UserVO userVo) {
        UserVO user = userService.register(userVo);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserVO> login(@RequestBody UserVO userVo) {
        UserVO user = userService.login(userVo);
        return ResponseEntity.ok(UserVO);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserVO>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users.stream().map(UserVO::fromEntity).collect(Collectors.toList()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserVO> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(UserVO.fromEntity(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserVO> updateUser(@PathVariable Long id, @RequestBody UserVO userVo) {
        User user = userService.updateUser(id, userVo);
        return ResponseEntity.ok(UserVO.fromEntity(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody UserVO userVo) {
        userService.forgotPassword(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody UserVO userVo) {
        userService.resetPassword(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-email")
    public ResponseEntity<Void> verifyEmail(@RequestBody UserVO userVo) {
        userService.verifyEmail(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/resend-verification-email")
    public ResponseEntity<Void> resendVerificationEmail(@RequestBody UserVO userVo) {
        userService.resendVerificationEmail(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody UserVO userVo) {
        userService.changePassword(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-email")
    public ResponseEntity<Void> changeEmail(@RequestBody UserVO userVo) {
        userService.changeEmail(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-phone")
    public ResponseEntity<Void> changePhone(@RequestBody UserVO userVo) {
        userService.changePhone(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-profile-image")
    public ResponseEntity<Void> changeProfileImage(@RequestBody UserVO userVo) {
        userService.changeProfileImage(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-role")
    public ResponseEntity<Void> changeRole(@RequestBody UserVO userVo) {
        userService.changeRole(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-gender")
    public ResponseEntity<Void> changeGender(@RequestBody UserVO userVo) {
        userService.changeGender(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-dob")
    public ResponseEntity<Void> changeDob(@RequestBody UserVO userVo) {
        userService.changeDob(userVo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change-name")
    public ResponseEntity<Void> changeName(@RequestBody UserVO userVo) {
        userService.changeName(userVo);
        return ResponseEntity.ok().build();
    }
    
}
