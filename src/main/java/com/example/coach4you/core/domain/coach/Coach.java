package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.List;

public class Coach {

  private Long id;
  private PersonDetails personDetails;
  private String yearsOfExperience;
  private String description;
  private ProfessionSpecialization professionSpecialization;
  private List<SportSpecialization> sportSpecializations;
  private List<ActivitySpecialization> activitySpecializations;

  public Coach(PersonDetails personDetails, String yearsOfExperience, String description,
      List<String> professions, List<SportSpecialization> sportSpecializations,
      List<ActivitySpecialization> activitySpecializations) {
    this.personDetails = personDetails;
    this.yearsOfExperience = yearsOfExperience;
    this.description = description;
    this.professionSpecialization = new ProfessionSpecialization(professions);
    this.sportSpecializations = sportSpecializations;
    this.activitySpecializations = activitySpecializations;
  }

  public Coach(Long id, PersonDetails personDetails, String yearsOfExperience,
      String description,
      ProfessionSpecialization professionSpecialization,
      List<SportSpecialization> sportSpecializations,
      List<ActivitySpecialization> activitySpecializations) {
    this.id = id;
    this.personDetails = personDetails;
    this.yearsOfExperience = yearsOfExperience;
    this.description = description;
    this.professionSpecialization = professionSpecialization;
    this.sportSpecializations = sportSpecializations;
    this.activitySpecializations = activitySpecializations;
  }

  public PersonDetails getPersonDetails() {
    return personDetails;
  }

  public String getYearsOfExperience() {
    return yearsOfExperience;
  }

  public String getDescription() {
    return description;
  }

  public ProfessionSpecialization getProfessionSpecialization() {
    return professionSpecialization;
  }

  public Long getId() {
    return id;
  }

  public List<SportSpecialization> getSportSpecializations() {
    return sportSpecializations;
  }

  public List<ActivitySpecialization> getActivitySpecializations() {
    return activitySpecializations;
  }
}
