package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.port.outgoing.ActivitySpecializationRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ActivityDictJpaRepositoryAdapter implements ActivitySpecializationRepository {

  private final ActivityDictionaryJpaRepository activityDictionaryJpaRepository;

  @Override
  public List<ActivitySpecialization> findActivitySpecializationsByIds(Set<Long> activityIds) {
    List<ActivityDictionaryDbModel> activityDictionaries =
        activityDictionaryJpaRepository.findAllById(activityIds);
    return ActivityDictionaryDbModel.toDomain(activityDictionaries);
  }
}
