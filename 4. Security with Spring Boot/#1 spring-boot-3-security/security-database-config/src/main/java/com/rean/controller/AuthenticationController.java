package com.rean.controller;

import com.rean.AuthenticationRequest;
import com.rean.AuthenticationResponse;
import com.rean.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping(value = "login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = userService.authentication(authenticationRequest);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }


}
