package com.rean.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
public class CustomMessageException extends RuntimeException{

    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private String code;
    @JsonIgnore
    private String cause;
    @JsonIgnore
    private Object stackTrace;
    @JsonIgnore
    private List<String> suppressed;
    @JsonIgnore
    private String localizedMessage;


    public CustomMessageException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CustomMessageException{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
