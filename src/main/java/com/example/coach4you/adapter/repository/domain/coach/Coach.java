package com.example.coach4you.adapter.repository.domain.coach;

import com.example.coach4you.adapter.repository.domain.user.PersonDetails;
import java.util.Set;

public class Coach {

  private PersonDetails personDetails;
  private Set<SportSpeciality> sportSpecialities;
  private Set<ProfessionalSpecialization> professionalSpecializations;
  private Set<ClassesActivity> classesActivities;

  public Coach(PersonDetails personDetails,
      Set<SportSpeciality> sportSpecialities,
      Set<ProfessionalSpecialization> professionalSpecializations,
      Set<ClassesActivity> classesActivities) {
    this.personDetails = personDetails;
    this.sportSpecialities = sportSpecialities;
    this.professionalSpecializations = professionalSpecializations;
    this.classesActivities = classesActivities;
  }

  public PersonDetails getPersonDetails() {
    return personDetails;
  }

  public Set<SportSpeciality> getSportSpecialities() {
    return sportSpecialities;
  }

  public Set<ProfessionalSpecialization> getProfessionalSpecializations() {
    return professionalSpecializations;
  }

  public Set<ClassesActivity> getClassesActivities() {
    return classesActivities;
  }
}
