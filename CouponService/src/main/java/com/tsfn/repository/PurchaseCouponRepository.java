package com.tsfn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsfn.model.PurchaseCoupon;
import com.tsfn.model.PurchaseCouponId;


  public interface PurchaseCouponRepository extends
  JpaRepository<PurchaseCoupon, PurchaseCouponId> {
	  
  }
 