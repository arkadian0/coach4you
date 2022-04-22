package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.user.PersonDetails;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoachTest {

  @Test
  void should_create_coach_to_save() {
    // given
    String coachDescription = "example description";
    String yearsOfExperience = "7-8";
    PersonDetails personDetails =
        new PersonDetails("Adrian", "Nowak", "abukalski@interia.pl", (short) 17);
    List<ActivitySpecialization> activitySpecializations =
        ActivitySpecialization.of(List.of(1L, 2L));
    List<SportSpecialization> sportSpecializations = SportSpecialization.of(List.of(1L, 2L));
    ProfessionSpecialization professionSpecialization =
        new ProfessionSpecialization(List.of("profession1, profession2"));

    //when
    Coach coach =
        new Coach(
            personDetails,
            yearsOfExperience,
            coachDescription,
            professionSpecialization,
            sportSpecializations,
            activitySpecializations);

    // then
    assertThat(coach.getId()).isNull();
    assertThat(coach.getDescription()).isEqualTo(coachDescription);
    assertThat(coach.getYearsOfExperience()).isEqualTo(yearsOfExperience);
    assertThat(coach.getPersonDetails().getAge()).isEqualTo(personDetails.getAge());
    assertThat(coach.getPersonDetails().getEmail()).isEqualTo(personDetails.getEmail());
    assertThat(coach.getPersonDetails().getFirstName()).isEqualTo(personDetails.getFirstName());
    assertThat(coach.getPersonDetails().getLastName()).isEqualTo(personDetails.getLastName());
    assertThat(coach.getProfessionSpecialization().getProfessionsAsString())
        .isEqualTo(professionSpecialization.getProfessionsAsString());
    assertThat(coach.getSportSpecializations().get(0)).isEqualTo(sportSpecializations.get(0));
    assertThat(coach.getSportSpecializations().get(1)).isEqualTo(sportSpecializations.get(1));
    assertThat(coach.getActivitySpecializations().get(0)).isEqualTo(activitySpecializations.get(0));
    assertThat(coach.getActivitySpecializations().get(1)).isEqualTo(activitySpecializations.get(1));
  }
}
