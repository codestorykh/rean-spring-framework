package com.rean.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {

        super(String.format("Course Id %d not found", id));
    }
}