package com.rean.exception;

import com.rean.dto.ResponseErrorTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomErrorException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomMessageException.class)
    public ResponseEntity<ResponseErrorTemplate> handleErrorException(CustomMessageException ex) {
        return ResponseEntity.ok(
                new ResponseErrorTemplate(
                        ex.getMessage(), ex.getCode(), new Object()
                ));
    }

}
