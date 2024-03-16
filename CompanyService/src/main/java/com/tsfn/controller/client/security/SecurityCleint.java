package com.tsfn.controller.client.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service", url = "http://localhost:8585")
public interface SecurityCleint {
	
	 @PostMapping("/auth/signin")
	  ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request);

	 @PostMapping("/auth/signup")
	 ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request);
	
	

}
