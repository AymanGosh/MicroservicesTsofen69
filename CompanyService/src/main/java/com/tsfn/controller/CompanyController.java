package com.tsfn.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.controller.client.coupon.Coupon;
import com.tsfn.controller.client.coupon.CouponClient;
import com.tsfn.model.Company;
import com.tsfn.service.CompanyService;
import com.tsfn.service.exceptions.CompanyAlreadyExistsException;
import com.tsfn.service.exceptions.CompanyNotFoundException;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CouponClient couponClient;
	
	
	@GetMapping("/{companyId}")
	public ResponseEntity<?> getCompanyById(@PathVariable int companyId) {
		try {
			Company company = companyService.getCompanyById(companyId);
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (CompanyNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createCompany(@RequestBody Company company) {
		try {
			Company createdCompany = companyService.createCompany(company);
			return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
		} catch (CompanyAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{companyId}")
	public ResponseEntity<?> updateCompany(@PathVariable int companyId, @RequestBody Company company) {
		try {
			company.setId(companyId);
			Company updatedCompany = companyService.updateCompany(company);
			return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
		} catch (CompanyNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{companyId}")
	public ResponseEntity<?> deleteCompany(@PathVariable int companyId) {
		try {
			companyService.deleteCompany(companyId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CompanyNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// create Coupon
	@PostMapping("/createcoupon")
	public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
		return couponClient.createCoupon(coupon);
	}
}
