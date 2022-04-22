package com.example.coach4you.adapter.api.response;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.List;
import java.util.stream.Collectors;

public record GetCoachResponse(long coachId, String firstName, String lastName,
                               String email, short age, String yearsOfExperience,
                               String description, List<String> professions,
                               List<SportSpecializationDto> sportSpecializations,
                               List<ActivitySpecializationDto> activitySpecializations) {

  public static GetCoachResponse of(Coach coach) {
    PersonDetails personDetails = coach.getPersonDetails();
    List<SportSpecializationDto> sportSpecializationDtos = createSportSpecializationDtos(coach);
    List<ActivitySpecializationDto> activitySpecializationDtos = createActivitySpecializationDtos(
        coach);
    return new GetCoachResponse(coach.getId(), personDetails.getFirstName(),
        personDetails.getLastName(), personDetails.getEmail(), personDetails.getAge(),
        coach.getYearsOfExperience(), coach.getDescription(),
        coach.getProfessionSpecialization().getProfessions(),
        sportSpecializationDtos, activitySpecializationDtos);
  }

  private static List<ActivitySpecializationDto> createActivitySpecializationDtos(Coach coach) {
    return coach.getActivitySpecializations().stream()
        .map(e -> new ActivitySpecializationDto(e.getId(), e.getActivityType(), e.getDescription()))
        .collect(Collectors.toList());
  }

  private static List<SportSpecializationDto> createSportSpecializationDtos(Coach coach) {
    return coach.getSportSpecializations().stream()
        .map(e -> new SportSpecializationDto(e.getId(), e.getSportType(), e.getDescription()))
        .collect(Collectors.toList());
  }
}
