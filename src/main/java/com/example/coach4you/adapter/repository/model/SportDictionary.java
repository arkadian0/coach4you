package com.example.coach4you.adapter.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sport_dictionary")
public class SportDictionary extends BaseEntity {

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public SportDictionary() {
  }
}
