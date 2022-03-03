package com.example.coach4you.core.service;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.user.PersonDetails;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.incoming.CoachServiceHandler;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CoachService implements CoachServiceHandler {

  private final CoachRepository coachRepository;

  @Override
  public long createCoach(CreateCoachCommand command) {
    PersonDetails personDetails = new PersonDetails(command.firstName(), command.lastName(),
        command.email(), command.age());
    Coach coach = new Coach(personDetails, command.yearsOfExperience(), command.description(),
        command.professions());
    return coachRepository.createCoach(coach, command.sportIds(), command.activityIds());
  }
}
