package com.example.coach4you.core.port.incoming;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.command.UpdateCoachCommand;

public interface CoachServiceHandler {

  long createCoach(CreateCoachCommand createCoachCommand);

  Coach getCoach(long coachId);

  void updateCoach(long coachId, UpdateCoachCommand updateCoachCommand);
}
