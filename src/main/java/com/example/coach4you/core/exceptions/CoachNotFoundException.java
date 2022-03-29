package com.example.coach4you.core.exceptions;

public class CoachNotFoundException extends RuntimeException {

  public CoachNotFoundException(long couchId) {
    super(String.format("Coach by id %s, not found", couchId));
  }

}
