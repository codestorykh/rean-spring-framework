package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HomeRequest {

    @JsonProperty("data")
    private String data;
}
