package com.example.coach4you.adapter.repository.domain.user;

public class PersonDetails {
  private String firstName;
  private String lastName;
  private String email;
  private Short age;

  public PersonDetails(String firstName, String lastName, String email, Short age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Short getAge() {
    return age;
  }
}
