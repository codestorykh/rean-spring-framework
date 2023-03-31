package com.rean.controller;

import com.rean.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public")
public class PublicController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> hello() {
        userService.saveUserRole();
        return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
    }

    @GetMapping("user/init")
    public ResponseEntity<Object> userInit() {
        userService.saveUserRole();
        return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
    }
}
