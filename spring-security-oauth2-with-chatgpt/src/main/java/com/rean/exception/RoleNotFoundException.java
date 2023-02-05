package com.rean.exception;

public class RoleNotFoundException extends RuntimeException {

  public RoleNotFoundException(String message) {
    super(message);
  }
}
