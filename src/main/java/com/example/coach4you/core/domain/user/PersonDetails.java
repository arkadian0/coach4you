package com.example.coach4you.core.domain.user;

public class PersonDetails {

  private String firstName;
  private String lastName;
  private Email email;
  private Short age;

  public PersonDetails(String firstName, String lastName, String email, Short age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = new Email(email);
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email.value();
  }

  public Short getAge() {
    return age;
  }

  public void update(String firstName, String lastName, String email, Short age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = new Email(email);
    this.age = age;
  }
}
