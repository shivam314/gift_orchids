package com.giftOrchids.giftOrchids.controller;

import com.giftOrchids.giftOrchids.dto.UserDetail;
import com.giftOrchids.giftOrchids.models.UserAddress;
import com.giftOrchids.giftOrchids.models.UserInfo;
import com.giftOrchids.giftOrchids.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserDetail getUserById(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/address")
    public List<UserAddress> getAddressByUserId(@RequestParam("userId") String userId) {
        return userService.getAddressByUserId(userId);
    }

    @PostMapping("/create-user")
    public void upsertUserDetail(
        @RequestBody UserInfo userInfo
    ) {
        userService.upsertUserDetail(userInfo);
    }

    @PostMapping("/add-address")
    public void upsertUserAddress(
        @RequestBody UserAddress userAddress
    ) {
        userService.upsertUserAddress(userAddress);
    }

}
