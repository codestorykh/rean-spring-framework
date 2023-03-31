package com.learnspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentCourseDto {

    @JsonProperty("student_id")
    private long studentId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_price")
    private double price;

}
