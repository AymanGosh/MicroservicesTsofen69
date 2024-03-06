package com.tsfn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsfn.model.Category;
import com.tsfn.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
		
	 	Optional<Coupon> findByTitleAndCompanyId(String title, int companyId);
	    List<Coupon> findByCompanyId(int companyId);
	    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);
	    List<Coupon> findByCompanyIdAndPriceLessThanEqual(int companyId, double maxPrice);

}
