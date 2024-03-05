package com.tsfn.service.exceptions;

public class CouponNotAvailableException extends RuntimeException {
    public CouponNotAvailableException(String message) {
        super(message);
    }
}

