package com.rean.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Home Page");
    }

}
