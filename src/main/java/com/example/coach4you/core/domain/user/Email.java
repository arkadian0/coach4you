package com.example.coach4you.core.domain.user;

import com.example.coach4you.core.exceptions.InvalidEmailException;
import org.apache.commons.validator.routines.EmailValidator;

public record Email(String value) {

  public Email {
    validate(value);
  }

  private void validate(String email) {
    if (!EmailValidator.getInstance().isValid(email)) {
      throw new InvalidEmailException(email);
    }
  }
}
