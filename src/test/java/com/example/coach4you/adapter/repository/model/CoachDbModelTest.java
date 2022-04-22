package com.example.coach4you.adapter.repository.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.service.CoachFactory;
import org.junit.jupiter.api.Test;

class CoachDbModelTest {

  @Test
  void should_correct_map_db_object_to_domain_object() {
    // given
    CoachDbModel coachDbModel = CoachFactory.getCoachDbModel();

    // when
    Coach domainCoach = coachDbModel.toDomain();

    // then
    assertThat(domainCoach.getId()).isEqualTo(coachDbModel.getId());
    assertThat(domainCoach.getPersonDetails().getFirstName())
        .isEqualTo(coachDbModel.getFirstName());
    assertThat(domainCoach.getPersonDetails().getLastName()).isEqualTo(coachDbModel.getLastName());
    assertThat(domainCoach.getPersonDetails().getEmail()).isEqualTo(coachDbModel.getEmail());
    assertThat(domainCoach.getPersonDetails().getAge()).isEqualTo(coachDbModel.getAge());
    assertThat(domainCoach.getPersonDetails().getAge()).isEqualTo(coachDbModel.getAge());
    assertThat(domainCoach.getDescription()).isEqualTo(coachDbModel.getDescription());
    assertThat(domainCoach.getYearsOfExperience()).isEqualTo(coachDbModel.getYearsOfExperience());
    assertThat(domainCoach.getProfessionSpecialization().getProfessionsAsString())
        .isEqualTo(coachDbModel.getProfessions());
    assertThat(domainCoach.getActivitySpecializations().get(0).getActivityType())
        .isEqualTo(coachDbModel.getActivityDictionaries().get(0).getType());
    assertThat(domainCoach.getActivitySpecializations().get(0).getDescription())
        .isEqualTo(coachDbModel.getActivityDictionaries().get(0).getDescription());
    assertThat(domainCoach.getActivitySpecializations().get(0).getId())
        .isEqualTo(coachDbModel.getActivityDictionaries().get(0).getId());
    assertThat(domainCoach.getSportSpecializations().get(0).getId())
        .isEqualTo(coachDbModel.getSportDictionaries().get(0).getId());
    assertThat(domainCoach.getSportSpecializations().get(0).getSportType())
        .isEqualTo(coachDbModel.getSportDictionaries().get(0).getType());
    assertThat(domainCoach.getSportSpecializations().get(0).getDescription())
        .isEqualTo(coachDbModel.getSportDictionaries().get(0).getDescription());
  }
}
