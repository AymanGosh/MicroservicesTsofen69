package com.tsfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CompanyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServicesApplication.class, args);
	}

}
