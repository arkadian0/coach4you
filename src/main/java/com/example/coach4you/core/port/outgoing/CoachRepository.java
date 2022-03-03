package com.example.coach4you.core.port.outgoing;

import com.example.coach4you.core.domain.coach.Coach;
import java.util.Set;

public interface CoachRepository {

  long createCoach(Coach coach, Set<Long> sportIds, Set<Long> activityIds);
}
