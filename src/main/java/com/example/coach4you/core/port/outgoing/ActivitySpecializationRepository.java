package com.example.coach4you.core.port.outgoing;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import java.util.Set;

public interface ActivitySpecializationRepository {

  Set<ActivitySpecialization> findActivitySpecializationsByIds(Set<Long> activityIds);
}
