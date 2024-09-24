package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderLines")
public class OrderLines {
    @Id
    private int lineId;
    private String orderId;
    private int pid;
    private int quantity;
    private long unitCost;
    private long totalCost;
}
