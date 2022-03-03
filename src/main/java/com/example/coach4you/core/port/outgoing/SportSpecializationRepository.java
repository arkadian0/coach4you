package com.example.coach4you.core.port.outgoing;

import com.example.coach4you.core.domain.coach.SportSpecialization;
import java.util.Set;

public interface SportSpecializationRepository {

  Set<SportSpecialization> findSportSpecializationsByIds(Set<Long> sportIds);
}
