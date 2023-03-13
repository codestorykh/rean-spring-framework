package com.rean.execption;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TodoErrorException(@JsonProperty("error_message") String errorMessage) {

    public TodoErrorException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

/*
public class TodoErrorException{

    @JsonProperty("error_message")
    private final String errorMessage;

    public TodoErrorException(String errorMessage) {
            this.errorMessage = errorMessage;
     }

    public String getErrorMessage() {
            return errorMessage;
   }
}
 */