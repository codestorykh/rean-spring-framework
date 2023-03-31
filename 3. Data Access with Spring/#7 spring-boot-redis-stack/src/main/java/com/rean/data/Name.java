package com.rean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Name {
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;
}