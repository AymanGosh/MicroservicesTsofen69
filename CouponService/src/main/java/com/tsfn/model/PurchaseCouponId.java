package com.tsfn.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseCouponId implements Serializable {
    private int customerId;
    private int couponId;
}
