package com.example.coach4you.adapter.repository.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "coach")
public class Coach extends BaseEntity {

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @Column(name = "email", nullable = false, length = 70)
  private String email;

  @Column(name = "age", nullable = false)
  private Short age;

  @OneToMany
  Set<ClassesDictionary> classesDictionaries;

  @OneToMany
  Set<SpecializationDictionary> specializationDictionaries;

  @OneToMany
  Set<SportDictionary> sportDictionaries;

  public Coach() {
  }

}
