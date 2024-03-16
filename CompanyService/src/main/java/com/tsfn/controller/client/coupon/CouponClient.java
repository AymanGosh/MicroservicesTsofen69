package com.tsfn.controller.client.coupon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="coupon-service", url = "http://localhost:8080")
public interface CouponClient {

	
	  @GetMapping("/coupons/{id}") 
	  ResponseEntity<?>getCouponById(@PathVariable("id") int id);
	  
	  @PostMapping("/coupons/create") 
	  ResponseEntity<?> createCoupon(@RequestBody Coupon coupon);
	  
	  @PutMapping("/coupons/update") 
	  ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon);
	  
	  @DeleteMapping("/coupons/delete/{couponId}") ResponseEntity<?>
	  deleteCoupon(@PathVariable("couponId") int couponId);
	  
	  @GetMapping("/coupons/company/{companyId}") ResponseEntity<?>
	  getAllCompanyCoupons(@PathVariable("companyId") int companyId);
	  
	  @GetMapping("/coupons/company/{companyId}/category/{   }") ResponseEntity<?>
	  getCompanyCouponsByCategory(@PathVariable("companyId") int companyId, @PathVariable("category") Category category);
	  
	  @GetMapping("/coupons/company/{companyId}/maxprice/{maxPrice}")
	  ResponseEntity<?> getCompanyCouponsByMaxPrice(@PathVariable("companyId") int companyId, @PathVariable("maxPrice") double maxPrice);
	 
}
