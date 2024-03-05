package com.tsfn.service.exceptions;

public class CouponAlreadyPurchasedException extends RuntimeException {
    public CouponAlreadyPurchasedException(String message) {
        super(message);
    }
}
