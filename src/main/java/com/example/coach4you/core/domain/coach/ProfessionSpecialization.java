package com.example.coach4you.core.domain.coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessionSpecialization {

  private final static String PROFESSION_SPLITTER = ";";
  private final List<String> professions;


  public ProfessionSpecialization(List<String> professions) {
    this.professions = professions;
  }

  public ProfessionSpecialization(String professions) {
    this.professions = Arrays.stream(professions.split(PROFESSION_SPLITTER))
        .collect(Collectors.toList());
  }

  public List<String> getProfessions() {
    return professions;
  }

  public String getProfessionsAsString() {
    return professions.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(";"));
  }
}
