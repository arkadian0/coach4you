package com.example.coach4you.core.service;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.ProfessionSpecialization;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.domain.user.PersonDetails;
import com.example.coach4you.core.exceptions.CoachNotFoundException;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.command.UpdateCoachCommand;
import com.example.coach4you.core.port.incoming.CoachServiceHandler;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
class CoachService implements CoachServiceHandler {

  private final CoachRepository coachRepository;

  @Override
  public long createCoach(final CreateCoachCommand createCoachCommand) {
    PersonDetails personDetails =
        new PersonDetails(
            createCoachCommand.firstName(),
            createCoachCommand.lastName(),
            createCoachCommand.email(),
            createCoachCommand.age());
    List<ActivitySpecialization> activitySpecializations =
        ActivitySpecialization.of(createCoachCommand.activityIds());
    List<SportSpecialization> sportSpecializations =
        SportSpecialization.of(createCoachCommand.sportIds());
    ProfessionSpecialization professionSpecialization =
        new ProfessionSpecialization(createCoachCommand.professions());
    Coach coach =
        new Coach(
            personDetails,
            createCoachCommand.yearsOfExperience(),
            createCoachCommand.description(),
            professionSpecialization,
            sportSpecializations,
            activitySpecializations);
    return coachRepository.createCoach(coach);
  }

  @Override
  public Coach getCoach(final long coachId) {
    return coachRepository
        .getCoachById(coachId)
        .orElseThrow(() -> new CoachNotFoundException(coachId));
  }

  @Override
  public void updateCoach(final UpdateCoachCommand updateCoachCommand) {
    validateExists(updateCoachCommand.coachId());

    PersonDetails personDetails =
        new PersonDetails(
            updateCoachCommand.firstName(),
            updateCoachCommand.lastName(),
            updateCoachCommand.email(),
            updateCoachCommand.age());
    List<ActivitySpecialization> activitySpecializations =
        ActivitySpecialization.of(updateCoachCommand.activityIds());
    List<SportSpecialization> sportSpecializations =
        SportSpecialization.of(updateCoachCommand.sportIds());
    ProfessionSpecialization professionSpecialization =
        new ProfessionSpecialization(updateCoachCommand.professions());
    Coach coach =
        new Coach(
            updateCoachCommand.coachId(),
            personDetails,
            updateCoachCommand.yearsOfExperience(),
            updateCoachCommand.description(),
            professionSpecialization,
            sportSpecializations,
            activitySpecializations);

    coachRepository.updateCoach(coach);
  }

  public void validateExists(long coachId) {
    if (!coachRepository.checkExists(coachId)) {
      throw new CoachNotFoundException(coachId);
    }
  }
}
