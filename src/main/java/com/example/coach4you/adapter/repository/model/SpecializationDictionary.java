package com.example.coach4you.adapter.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialization_dictionary")
public class SpecializationDictionary extends BaseEntity{

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public SpecializationDictionary() {
  }
}
