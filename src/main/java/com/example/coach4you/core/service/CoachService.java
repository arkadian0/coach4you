package com.example.coach4you.core.service;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.domain.user.PersonDetails;
import com.example.coach4you.core.exceptions.CoachNotFoundException;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.incoming.CoachServiceHandler;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CoachService implements CoachServiceHandler {

  private final CoachRepository coachRepository;

  @Override
  public long createCoach(final CreateCoachCommand command) {
    PersonDetails personDetails = new PersonDetails(command.firstName(), command.lastName(),
        command.email(), command.age());
    List<ActivitySpecialization> activitySpecializations = ActivitySpecialization
        .of(command.activityIds());
    List<SportSpecialization> sportSpecializations = SportSpecialization.of(command.sportIds());
    Coach coach = new Coach(personDetails, command.yearsOfExperience(), command.description(),
        command.professions(), sportSpecializations, activitySpecializations);
    return coachRepository.createCoach(coach);
  }

  @Override
  public Coach getCoach(final long coachId) {
    return coachRepository.getCoachById(coachId)
        .orElseThrow(() -> new CoachNotFoundException(coachId));
  }

}
