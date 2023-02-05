package com.rean.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
  private int errorCode;
  private String errorMessage;
  private LocalDateTime timestamp;

  public ErrorResponse(int errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.timestamp = LocalDateTime.now();
  }

  public ErrorResponse() {

  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
