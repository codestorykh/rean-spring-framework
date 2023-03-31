package com.rean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeExceptionNotFound extends RuntimeException {
    private static final long serialVersionUID = -5274604505720526425L;

    public EmployeeExceptionNotFound(String message) {
        super(message);
    }
}
