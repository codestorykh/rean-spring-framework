package com.rean.controller;

import com.rean.service.FakeAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FakeApiController {

    private final FakeAPIService fakeAPIService;

    @GetMapping("user")
    public ResponseEntity<Object> getUser() {
        return ResponseEntity.ok().body(fakeAPIService.getUser());
    }

    @GetMapping("users")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(fakeAPIService.getUsers());
    }
}
