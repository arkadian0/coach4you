package com.example.coach4you.adapter.repository.domain.user;

public class OrdinaryUser {

  private PersonDetails personDetails;

  public OrdinaryUser(PersonDetails personDetails) {
    this.personDetails = personDetails;
  }

  public PersonDetails getPersonDetails() {
    return personDetails;
  }
}
