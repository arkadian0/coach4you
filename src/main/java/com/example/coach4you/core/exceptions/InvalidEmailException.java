package com.example.coach4you.core.exceptions;

public class InvalidEmailException extends RuntimeException {

  public InvalidEmailException(String email) {
    super(String.format("Incorrect email address : %s", email));
  }
}
