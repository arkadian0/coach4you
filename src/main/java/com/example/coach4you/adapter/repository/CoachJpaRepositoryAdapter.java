package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import com.example.coach4you.adapter.repository.model.CoachDbModel;
import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class CoachJpaRepositoryAdapter implements CoachRepository {

  private final CoachJpaRepository coachJpaRepository;
  private final ActivityDictionaryJpaRepository activityDictionaryJpaRepository;
  private final SportDictionaryJpaRepository sportDictionaryJpaRepository;

  @Override
  public long createCoach(Coach coach, Set<Long> sportIds, Set<Long> activityIds) {
    List<ActivityDictionaryDbModel> activityDictionaries = activityDictionaryJpaRepository.findAllById(activityIds);
    List<SportDictionaryDbModel> sportDictionaries = sportDictionaryJpaRepository.findAllById(activityIds);
    CoachDbModel coachDbModel = CoachDbModel.of(coach, activityDictionaries, sportDictionaries);
    return coachJpaRepository.save(coachDbModel).getId();
  }
}
