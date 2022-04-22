package com.example.coach4you.core.domain.coach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SportSpecializationTest {

  @Test
  void should_create_sport_specializations_from_ids() {
    // given
    List<Long> sportSpecializationIds = List.of(111L, 112L);

    // when
    List<SportSpecialization> sportSpecializations = SportSpecialization.of(sportSpecializationIds);

    // then
    assertThat(sportSpecializations.get(0).getId()).isEqualTo(sportSpecializationIds.get(0));
    assertThat(sportSpecializations.get(1).getId()).isEqualTo(sportSpecializationIds.get(1));
  }
}
