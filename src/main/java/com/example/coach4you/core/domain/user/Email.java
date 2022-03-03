package com.example.coach4you.core.domain.user;

import com.example.coach4you.core.exceptions.InvalidEmailException;
import org.apache.commons.validator.routines.EmailValidator;

class Email {

  private String value;

  Email(String value) {
    isValid();
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void isValid() {
    if (!EmailValidator.getInstance().isValid(value)) {
      throw new InvalidEmailException(value);
    }
  }
}
