package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "user")
public class UserInfo {
    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String authToken;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
}
