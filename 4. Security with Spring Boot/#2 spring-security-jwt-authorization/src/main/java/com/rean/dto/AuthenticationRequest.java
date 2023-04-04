package com.rean.dto;

public record AuthenticationRequest(
        String username,
        String password
){
}
