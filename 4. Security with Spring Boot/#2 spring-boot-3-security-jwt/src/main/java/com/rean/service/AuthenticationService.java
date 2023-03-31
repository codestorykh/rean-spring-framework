package com.rean.service;

import com.rean.dto.auth.AuthenticationRequest;
import com.rean.dto.auth.AuthenticationResponse;
import com.rean.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
