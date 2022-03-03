package com.example.coach4you.core.port.command;

import java.util.Set;

public record CreateCoachCommand(String firstName, String lastName, String email, short age,
                          String yearsOfExperience, String description, Set<Long> sportIds,
                          Set<Long> activityIds, Set<String> professions) {

  public static CreateCoachCommand of(String firstName, String lastName, String email, short age,
      String yearsOfExperience, String description, Set<Long> sportIds,
      Set<Long> activityIds, Set<String> professions) {
    return new CreateCoachCommand(firstName, lastName, email, age, yearsOfExperience, description,
        sportIds, activityIds, professions);
  }
}