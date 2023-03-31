package com.rean;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("email") String email) {
}
