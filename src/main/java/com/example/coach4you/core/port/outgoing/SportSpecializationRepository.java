package com.example.coach4you.core.port.outgoing;

import com.example.coach4you.core.domain.coach.SportSpecialization;
import java.util.List;
import java.util.Set;

public interface SportSpecializationRepository {

  List<SportSpecialization> findSportSpecializationsByIds(Set<Long> sportIds);
}
