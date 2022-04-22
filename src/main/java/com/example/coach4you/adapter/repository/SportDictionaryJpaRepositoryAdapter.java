package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.port.outgoing.SportSpecializationRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class SportDictionaryJpaRepositoryAdapter implements SportSpecializationRepository {

  private final SportDictionaryJpaRepository sportDictionaryJpaRepository;

  @Override
  public List<SportSpecialization> findSportSpecializationsByIds(Set<Long> activityIds) {
    List<SportDictionaryDbModel> sportDictionaries =
        sportDictionaryJpaRepository.findAllById(activityIds);
    return SportDictionaryDbModel.toDomain(sportDictionaries);
  }
}
