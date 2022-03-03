package com.example.coach4you.core.exceptions;

public class InvalidEmailException extends RuntimeException {

  public InvalidEmailException(String email) {
    super("Niepoprawny adres email : " + email);
  }

}
