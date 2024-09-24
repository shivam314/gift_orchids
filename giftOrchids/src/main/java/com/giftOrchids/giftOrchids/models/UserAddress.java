package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class UserAddress {
    @Id
    private String addressId;
    private String userId;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String addressType;
    private Boolean isPrimaryAddress;
    private String referenceName;
    private String referenceContact;
}
