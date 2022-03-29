package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import com.example.coach4you.adapter.repository.model.CoachDbModel;
import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.SportSpecialization;
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
    List<ActivityDictionaryDbModel> activityDictionaries = activityDictionaryJpaRepository
        .findAllById(
            coach.getActivitySpecializations()
                .stream()
                .map(ActivitySpecialization::getId)
                .collect(Collectors.toList()));
    List<SportDictionaryDbModel> sportDictionaries = sportDictionaryJpaRepository
        .findAllById(coach.getSportSpecializations()
            .stream()
            .map(SportSpecialization::getId)
            .collect(Collectors.toList()));
    CoachDbModel coachDbModel = CoachDbModel.of(coach, activityDictionaries, sportDictionaries);

    return coachJpaRepository.save(coachDbModel).getId();
  }

  @Override
  public Optional<Coach> getCoachById(long coachId) {
    return coachJpaRepository.findById(coachId)
        .map(CoachDbModel::toDomain);
  }
}
