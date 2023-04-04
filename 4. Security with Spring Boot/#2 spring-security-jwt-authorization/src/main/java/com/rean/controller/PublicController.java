package com.rean.controller;

import com.rean.dto.UserRequest;
import com.rean.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicController {

    private final UserService userService;

    @PostMapping("/accounts/register")
    public ResponseEntity<Object> register(@RequestBody UserRequest userRequest) {
        log.info("Intercept registration new user with req: {}", userRequest);
        return ResponseEntity.ok(userService.create(userRequest));
    }

}
