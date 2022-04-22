package com.example.coach4you.core.service;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import com.example.coach4you.adapter.repository.model.CoachDbModel;
import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.ProfessionSpecialization;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.domain.coach.enums.ActivityType;
import com.example.coach4you.core.domain.coach.enums.SportType;
import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.List;

public class CoachFactory {

  public static Coach getCoach() {
    PersonDetails personDetails =
        new PersonDetails("John", "Lenon", "j.lenon@gmail.com", (short) 15);
    List<ActivitySpecialization> activitySpecializations =
        ActivitySpecialization.of(List.of(1L, 2L));
    List<SportSpecialization> sportSpecializations = SportSpecialization.of(List.of(1L, 2L));
    ProfessionSpecialization professionSpecialization =
        new ProfessionSpecialization(List.of("Coach", "Instructor"));
    return new Coach(
        personDetails,
        "2-4",
        "Best coach on the world",
        professionSpecialization,
        sportSpecializations,
        activitySpecializations);
  }

  public static CoachDbModel getCoachDbModel() {
    List<ActivityDictionaryDbModel> activitySpecializations =
        List.of(
            ActivityDictionaryDbModel.builder()
                .id(1L)
                .description("For children")
                .type(ActivityType.FOR_CHILDREN)
                .build());
    List<SportDictionaryDbModel> sportSpecializations =
        List.of(
            SportDictionaryDbModel.builder()
                .id(1L)
                .type(SportType.FOOTBALL)
                .description("Football")
                .build());
    return CoachDbModel.builder()
        .firstName("Michael")
        .lastName("Phelps")
        .email("m.phelps@gmail.com")
        .age((short) 35)
        .description("Coach of swimming")
        .professions("Coach;Instructor")
        .activityDictionaries(activitySpecializations)
        .sportDictionaries(sportSpecializations)
        .build();
  }
}
