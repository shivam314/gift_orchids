package com.giftOrchids.giftOrchids.dto;

import com.giftOrchids.giftOrchids.models.UserAddress;
import com.giftOrchids.giftOrchids.models.UserInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDetail {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String authToken;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UserAddress userAddresses;

    public UserDetail(UserInfo userInfo, UserAddress userAddress) {
        this.userId = userInfo.getUserId();
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.email = userInfo.getEmail();
        this.contact = userInfo.getContact();
        this.authToken = userInfo.getAuthToken();
        this.createdDate = userInfo.getCreatedDate();
        this.lastUpdatedDate = userInfo.getLastUpdatedDate();
        this.userAddresses = userAddress;
    }
}
