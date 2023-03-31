package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author dawnt
 * @Date 4/2/2022 9:23 AM
 * @Version 1.0
 */
@Data
public class StudentRequest {
    @JsonProperty("percentage_range")
    private double percentageRange;
}
