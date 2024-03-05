package com.tsfn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.model.Category;
import com.tsfn.model.Coupon;
import com.tsfn.service.CouponService;
import com.tsfn.service.exceptions.CouponAlreadyExistsException;
import com.tsfn.service.exceptions.CouponAlreadyPurchasedException;
import com.tsfn.service.exceptions.CouponNotAvailableException;
import com.tsfn.service.exceptions.CouponNotFoundException;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getCouponById(@PathVariable int id) {
        try {
            Coupon coupon = couponService.getCouponById(id);
            return new ResponseEntity<>(coupon, HttpStatus.OK);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
        try {
            Coupon createdCoupon = couponService.addCoupon(coupon);
            return new ResponseEntity<>(createdCoupon, HttpStatus.CREATED);
        } catch (CouponAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
 

    @PutMapping("/update")
    public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon) {
        try {
            Coupon updatedCoupon = couponService.updateCoupon(coupon);
            return new ResponseEntity<>(updatedCoupon, HttpStatus.OK);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{couponId}")
    public ResponseEntity<?> deleteCoupon(@PathVariable int couponId) {
        try {
            couponService.deleteCoupon(couponId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getAllCompanyCoupons(@PathVariable int companyId) {
        try {
            List<Coupon> companyCoupons = couponService.getAllCompanyCoupons(companyId);
            return new ResponseEntity<>(companyCoupons, HttpStatus.OK);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/company/{companyId}/category/{category}")
    public ResponseEntity<?> getCompanyCouponsByCategory(@PathVariable int companyId, @PathVariable Category category) {
        try {
            List<Coupon> companyCouponsByCategory = couponService.getCompanyCouponsByCategory(companyId, category);
            return new ResponseEntity<>(companyCouponsByCategory, HttpStatus.OK);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/company/{companyId}/maxprice/{maxPrice}")
    public ResponseEntity<?> getCompanyCouponsByMaxPrice(@PathVariable int companyId, @PathVariable double maxPrice) {
        try {
            List<Coupon> companyCouponsByMaxPrice = couponService.getCompanyCouponsByMaxPrice(companyId, maxPrice);
            return new ResponseEntity<>(companyCouponsByMaxPrice, HttpStatus.OK);
        } catch (CouponNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{couponId}/purchase/{customerId}")
    public ResponseEntity<?> purchaseCoupon(@PathVariable int couponId, @PathVariable int customerId) {
        try {
            couponService.purchaseCoupon(customerId, couponId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CouponNotFoundException | CouponNotAvailableException | CouponAlreadyPurchasedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
