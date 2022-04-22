package com.example.coach4you.core.domain.user;

import com.example.coach4you.core.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmailTest {

  @Test
  void should_create_email() {
    //given
    String correctEmail = "a.nowak@interia.pl";

    //when
    Email email = new Email(correctEmail);

    //then
    assertThat(email.value()).isEqualTo(correctEmail);
  }

  @ParameterizedTest
  @ValueSource(strings = {"anowak$interia.pl", "anowak.interia.pl","anowak","","anowak@@interia.pl", "anowak@interia", "anowak@"})
  void should_throw_exception_when_email_is_incorrect(String emailParam) {
    assertThatExceptionOfType(InvalidEmailException.class)
            .isThrownBy(() -> new Email(emailParam))
            .withMessage(String.format("Incorrect email address : %s", emailParam));
  }

}
