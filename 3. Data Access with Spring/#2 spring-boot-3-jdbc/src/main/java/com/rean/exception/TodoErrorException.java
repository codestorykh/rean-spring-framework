package com.rean.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TodoErrorException(@JsonProperty("error_message") String errorMessage) {

    public TodoErrorException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}