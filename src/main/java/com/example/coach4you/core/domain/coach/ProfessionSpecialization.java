package com.example.coach4you.core.domain.coach;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfessionSpecialization {

  private Set<String> professions;

  public ProfessionSpecialization(Set<String> professions) {
    this.professions = professions;
  }

  public String getProfessionsAsString() {
    return this.professions.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(";"));
  }
}
