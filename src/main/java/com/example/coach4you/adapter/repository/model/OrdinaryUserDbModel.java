package com.example.coach4you.adapter.repository.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ordinary_user")
public class OrdinaryUserDbModel extends BaseEntityAudit {

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @Column(name = "email", nullable = false, length = 70)
  private String email;

  @Column(name = "age", nullable = false)
  private Short age;

  public OrdinaryUserDbModel() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    OrdinaryUserDbModel that = (OrdinaryUserDbModel) o;
    return Objects.equals(firstName, that.firstName) && Objects
        .equals(lastName, that.lastName) && Objects.equals(email, that.email)
        && Objects.equals(age, that.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), firstName, lastName, email, age);
  }
}
