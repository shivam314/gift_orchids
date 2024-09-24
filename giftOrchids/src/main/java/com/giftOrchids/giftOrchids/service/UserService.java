package com.giftOrchids.giftOrchids.service;

import com.giftOrchids.giftOrchids.dto.UserDetail;
import com.giftOrchids.giftOrchids.models.UserAddress;
import com.giftOrchids.giftOrchids.models.UserInfo;
import com.giftOrchids.giftOrchids.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDetail getUserById(String userId) {
        UserInfo userInfo = userRepo.findUserByUserId(UUID.fromString(userId));
        UserAddress userAddress = userRepo.findPrimaryAddressByUserId(UUID.fromString(userId));

        return new UserDetail(userInfo, userAddress);
    }

    public List<UserAddress> getAddressByUserId(String userId) {
        return userRepo.findAddressesByUserId(UUID.fromString(userId));
    }

    public void upsertUserDetail(UserInfo userInfo) {
        int result = userRepo.upsertUserDetail(userInfo);
        if (result == 1) {
            log.info("A new user detail added successfully!");
        } else {
            log.info("An existing user detail have been updated successfully!");
        }
    }

    public void upsertUserAddress(UserAddress userAddress) {
        int result = userRepo.upsertUserAddress(userAddress);

        if (result == 1) {
            log.info("A new address detail added successfully!");
        } else {
            log.info("An existing address have been updated successfully!");
        }
    }

}
