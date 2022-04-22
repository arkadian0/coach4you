package com.example.coach4you.core.domain.coach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfessionSpecializationTest {

  private static final String PROFESSION_SPLITTER = ";";

  @Test
  void should_create_profession_specialization_from_string() {
    // given
    String profession1 = "Coach";
    String profession2 = "Instructor";
    String professions = profession1 + PROFESSION_SPLITTER + profession2;

    // when
    ProfessionSpecialization professionSpecialization = new ProfessionSpecialization(professions);

    // then
    assertThat(professionSpecialization.getProfessions())
        .isEqualTo(List.of(profession1, profession2));
  }

  @Test
  void should_create_string_of_professions_from_list() {
    // given
    String profession1 = "Coach";
    String profession2 = "Instructor";
    ProfessionSpecialization professionSpecialization =
        new ProfessionSpecialization(List.of(profession1, profession2));

    // when
    String professionsAsString = professionSpecialization.getProfessionsAsString();

    // then
    assertThat(professionsAsString).isEqualTo(profession1 + PROFESSION_SPLITTER + profession2);
  }
}
