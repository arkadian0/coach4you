package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.coach.enums.ActivityType;

public class ActivitySpecialization {

  private Long id;
  private ActivityType activityType;

  public ActivitySpecialization(
      ActivityType activityType) {
    this.activityType = activityType;
  }

  public ActivityType getActivityType() {
    return activityType;
  }
}
