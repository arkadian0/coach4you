package com.example.coach4you.adapter.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "classes_dictionary")
public class ClassesDictionary extends BaseEntity{

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public ClassesDictionary() {
  }
}
