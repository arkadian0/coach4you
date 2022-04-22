package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.coach.enums.ActivityType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ActivitySpecialization {

  private Long id;
  private ActivityType activityType;
  private String description;

  public ActivitySpecialization(Long id) {
    this.id = id;
  }

  public static List<ActivitySpecialization> of(List<Long> activityIds) {
    return activityIds.stream().map(ActivitySpecialization::new).collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public ActivityType getActivityType() {
    return activityType;
  }

  public String getDescription() {
    return description;
  }
}
