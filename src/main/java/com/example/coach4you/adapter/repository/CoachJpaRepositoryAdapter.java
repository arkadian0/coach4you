package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import com.example.coach4you.adapter.repository.model.CoachDbModel;
import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.exceptions.CoachNotFoundException;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class CoachJpaRepositoryAdapter implements CoachRepository {

  private final CoachJpaRepository coachJpaRepository;
  private final ActivityDictionaryJpaRepository activityDictionaryJpaRepository;
  private final SportDictionaryJpaRepository sportDictionaryJpaRepository;

  @Override
  public long createCoach(Coach coach) {
    List<ActivityDictionaryDbModel> activityDictionaries =
        getAllActivityDictionariesByIds(coach.getActivitySpecializations());
    List<SportDictionaryDbModel> sportDictionaries =
        getAllSportDictionariesByIds(coach.getSportSpecializations());
    CoachDbModel coachDbModel = CoachDbModel.of(coach, activityDictionaries, sportDictionaries);

    return coachJpaRepository.save(coachDbModel).getId();
  }

  @Override
  public Optional<Coach> getCoachById(long coachId) {
    return coachJpaRepository.findById(coachId).map(CoachDbModel::toDomain);
  }

  @Override
  public void updateCoach(Coach coach) {
    CoachDbModel coachDb =
        coachJpaRepository
            .findById(coach.getId())
            .orElseThrow(() -> new CoachNotFoundException(coach.getId()));
    List<ActivityDictionaryDbModel> activityDictionaries =
        getAllActivityDictionariesByIds(coach.getActivitySpecializations());
    List<SportDictionaryDbModel> sportDictionaries =
        getAllSportDictionariesByIds(coach.getSportSpecializations());

    coachDb.setAge(coach.getPersonDetails().getAge());
    coachDb.setFirstName(coach.getPersonDetails().getFirstName());
    coachDb.setLastName(coach.getPersonDetails().getLastName());
    coachDb.setEmail(coach.getPersonDetails().getEmail());
    coachDb.setYearsOfExperience(coach.getYearsOfExperience());
    coachDb.setDescription(coach.getDescription());
    coachDb.setProfessions(coach.getProfessionSpecialization().getProfessionsAsString());
    coachDb.setActivityDictionaries(activityDictionaries);
    coachDb.setSportDictionaries(sportDictionaries);
  }

  private List<ActivityDictionaryDbModel> getAllActivityDictionariesByIds(
      List<ActivitySpecialization> activitySpecializations) {
    return activityDictionaryJpaRepository.findAllById(
        activitySpecializations.stream()
            .map(ActivitySpecialization::getId)
            .collect(Collectors.toList()));
  }

  private List<SportDictionaryDbModel> getAllSportDictionariesByIds(
      List<SportSpecialization> sportSpecializations) {
    return sportDictionaryJpaRepository.findAllById(
        sportSpecializations.stream().map(SportSpecialization::getId).collect(Collectors.toList()));
  }
}
