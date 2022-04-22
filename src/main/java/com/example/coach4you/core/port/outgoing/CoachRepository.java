package com.example.coach4you.core.port.outgoing;

import com.example.coach4you.core.domain.coach.Coach;

import java.util.Optional;

public interface CoachRepository {

  long createCoach(Coach coach);

  Optional<Coach> getCoachById(long coachId);

  void updateCoach(Coach coach);

  boolean checkExists(long coachId);
}
