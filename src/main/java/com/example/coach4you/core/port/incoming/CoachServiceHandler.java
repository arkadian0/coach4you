package com.example.coach4you.core.port.incoming;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.port.command.CreateCoachCommand;

public interface CoachServiceHandler {

  long createCoach(CreateCoachCommand createCoachCommand);

  Coach getCoach(long coachId);
}
