package com.example.coach4you.core.port.command;

import java.util.List;

public record CreateCoachCommand(String firstName, String lastName, String email, Short age,
                                 String yearsOfExperience, String description, List<Long> sportIds,
                                 List<Long> activityIds, List<String> professions) {

  public static CreateCoachCommand of(String firstName, String lastName, String email, Short age,
      String yearsOfExperience, String description, List<Long> sportIds,
      List<Long> activityIds, List<String> professions) {
    return new CreateCoachCommand(firstName, lastName, email, age, yearsOfExperience, description,
        sportIds, activityIds, professions);
  }
}