package com.example.coach4you.core.domain.user;

public class OrdinaryUser {

  private Long id;
  private PersonDetails personDetails;

  public OrdinaryUser(PersonDetails personDetails) {
    this.personDetails = personDetails;
  }

  public PersonDetails getPersonDetails() {
    return personDetails;
  }
}
