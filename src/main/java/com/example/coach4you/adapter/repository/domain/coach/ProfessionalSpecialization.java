package com.example.coach4you.adapter.repository.domain.coach;

import com.example.coach4you.adapter.repository.domain.coach.enums.ProfessionalSpecializationType;

public class ProfessionalSpecialization {

  private ProfessionalSpecializationType professionalSpecializationType;

  public ProfessionalSpecialization(
      ProfessionalSpecializationType professionalSpecializationType) {
    this.professionalSpecializationType = professionalSpecializationType;
  }

  public ProfessionalSpecializationType getProfessionalSpecializationType() {
    return professionalSpecializationType;
  }

}
