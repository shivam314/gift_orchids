package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    private UUID orderId;
    private String userId;
    private String status;  //created, cancel, packed, shipped, delivered
    private long orderTotal; //total price
    private int orderQuantity; // total lines quantity
    private LocalDateTime orderCreatedDate;
    private LocalDateTime lastUpdatedDate;
}
