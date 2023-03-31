package com.rean.excpetion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandle {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleExceptionError(Exception ex) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getLocalizedMessage(),
                "Bad Request");
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFound(ResourceNotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getLocalizedMessage(),
                "Resource Not Found.");
    }
}
