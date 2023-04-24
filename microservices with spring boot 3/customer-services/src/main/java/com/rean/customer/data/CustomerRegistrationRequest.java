package com.rean.customer.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerRegistrationRequest(@JsonProperty("first_name") String firstName,
                                          @JsonProperty("last_name") String lastName,
                                          @JsonProperty("email") String email,
                                          @JsonProperty("id_type") String idType,
                                          @JsonProperty("id_value") String idValue,
                                          @JsonProperty("phone_number") String phoneNumber,
                                          String gender) {
}
