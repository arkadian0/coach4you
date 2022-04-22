package com.example.coach4you.core.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonDetailsTest {

  @Test
  void should_correct_create_person_details() {
    // given
    String firstName = "Adrian";
    String lastName = "Adrian";
    Short age = 15;
    String email = "nowak.adrian@gmail.com";

    //when
    PersonDetails personDetails = new PersonDetails(firstName, lastName, email, age);

    // then
    assertThat(personDetails.getFirstName()).isEqualTo(firstName);
    assertThat(personDetails.getLastName()).isEqualTo(lastName);
    assertThat(personDetails.getAge()).isEqualTo(age);
    assertThat(personDetails.getEmail()).isEqualTo(email);
  }
}
