package com.example.coach4you.core.service;

import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.port.outgoing.SportSpecializationRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SportDictionaryService {

  private final SportSpecializationRepository sportSpecializationRepository;

  public Set<SportSpecialization> findSportSpecializationsByIds(Set<Long> activityIds) {
    return sportSpecializationRepository.findSportSpecializationsByIds(activityIds);
  }
}
