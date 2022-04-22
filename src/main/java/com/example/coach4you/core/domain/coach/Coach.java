package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coach {

  private Long id;
  private PersonDetails personDetails;
  private String yearsOfExperience;
  private String description;
  private ProfessionSpecialization professionSpecialization;
  private List<SportSpecialization> sportSpecializations;
  private List<ActivitySpecialization> activitySpecializations;

  public Coach(
      PersonDetails personDetails,
      String yearsOfExperience,
      String description,
      ProfessionSpecialization professionSpecialization,
      List<SportSpecialization> sportSpecializations,
      List<ActivitySpecialization> activitySpecializations) {
    this.personDetails = personDetails;
    this.yearsOfExperience = yearsOfExperience;
    this.description = description;
    this.professionSpecialization = professionSpecialization;
    this.sportSpecializations = sportSpecializations;
    this.activitySpecializations = activitySpecializations;
  }
}
