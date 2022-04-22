package com.example.coach4you.core.domain.coach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ActivitySpecializationTest {

  @Test
  void should_create_activity_specializations_from_ids() {
    // given
    List<Long> activitySpecializationIds = List.of(111L, 112L);

    // when
    List<ActivitySpecialization> activitySpecializations = ActivitySpecialization.of(activitySpecializationIds);

    // then
    assertThat(activitySpecializations.get(0).getId()).isEqualTo(activitySpecializationIds.get(0));
    assertThat(activitySpecializations.get(1).getId()).isEqualTo(activitySpecializationIds.get(1));
  }

}
