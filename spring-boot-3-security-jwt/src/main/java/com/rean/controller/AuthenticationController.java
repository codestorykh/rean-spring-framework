package com.rean.controller;

import com.rean.dto.auth.AuthenticationRequest;
import com.rean.dto.auth.AuthenticationResponse;
import com.rean.dto.auth.RegisterRequest;
import com.rean.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/auth", "/api/auth"})
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request) {

    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {

    return ResponseEntity.ok(service.authenticate(request));
  }


}