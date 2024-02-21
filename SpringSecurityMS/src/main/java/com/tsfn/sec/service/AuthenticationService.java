package com.tsfn.sec.service;

import com.tsfn.sec.controller.request.SignUpRequest;
import com.tsfn.sec.controller.request.SigninRequest;
import com.tsfn.sec.controller.response.JwtAuthenticationResponse;

public interface AuthenticationService {
	
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
