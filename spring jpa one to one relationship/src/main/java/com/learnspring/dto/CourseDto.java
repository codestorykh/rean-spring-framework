package com.learnspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CourseDto {

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_price")
    private double price;

    @JsonProperty("create_at")
    private Date createAt;
}
