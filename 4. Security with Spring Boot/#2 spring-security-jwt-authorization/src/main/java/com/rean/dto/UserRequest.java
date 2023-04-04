package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        String email,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("roles") List<String> roles) {

}
