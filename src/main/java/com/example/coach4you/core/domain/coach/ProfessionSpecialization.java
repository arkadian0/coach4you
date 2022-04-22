package com.example.coach4you.core.domain.coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfessionSpecialization {

  private static final String PROFESSION_SPLITTER = ";";
  private List<String> professions;

  public ProfessionSpecialization(String professions) {
    this.professions =
        Arrays.stream(professions.split(PROFESSION_SPLITTER)).collect(Collectors.toList());
  }

  public String getProfessionsAsString() {
    return professions.stream().map(String::valueOf).collect(Collectors.joining(";"));
  }
}
