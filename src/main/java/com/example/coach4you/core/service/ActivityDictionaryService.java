package com.example.coach4you.core.service;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.port.outgoing.ActivitySpecializationRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ActivityDictionaryService {

  private final ActivitySpecializationRepository activitySpecializationRepository;

  public List<ActivitySpecialization> findActivitySpecializationsByIds(Set<Long> activityIds) {
    return activitySpecializationRepository.findActivitySpecializationsByIds(activityIds);
  }
}
