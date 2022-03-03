package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.Set;

public class Coach {

  private Long id;
  private PersonDetails personDetails;
  private String yearsOfExperience;
  private String description;
  private ProfessionSpecialization professionSpecialization;


  public Coach(PersonDetails personDetails, String yearsOfExperience, String description,
      Set<String> professions) {
    this.personDetails = personDetails;
    this.yearsOfExperience = yearsOfExperience;
    this.description = description;
    this.professionSpecialization = new ProfessionSpecialization(professions);
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
}
