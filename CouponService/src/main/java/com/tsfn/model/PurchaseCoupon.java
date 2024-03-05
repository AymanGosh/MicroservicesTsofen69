package com.tsfn.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table (name ="purchased")
@AllArgsConstructor
public class PurchaseCoupon implements Serializable {

	@Id
	private PurchaseCouponId purchaseCouponId;

}
