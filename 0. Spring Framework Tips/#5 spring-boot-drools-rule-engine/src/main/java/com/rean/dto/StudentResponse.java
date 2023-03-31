package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author dawnt
 * @Date 4/2/2022 9:31 AM
 * @Version 1.0
 */
@Data
public class StudentResponse {

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("gpa")
    private double gpa;

    @JsonProperty("desc")
    private String desc;
}
