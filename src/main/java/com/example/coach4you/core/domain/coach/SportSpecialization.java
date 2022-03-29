package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.coach.enums.SportType;
import java.util.List;
import java.util.stream.Collectors;

public class SportSpecialization {

  private Long id;
  private SportType sportType;
  private String description;

  public SportSpecialization(Long id,
      SportType sportType, String description) {
    this.id = id;
    this.sportType = sportType;
    this.description = description;
  }

  public SportSpecialization(Long id) {
    this.id = id;
  }

  public static List<SportSpecialization> of(List<Long> sportIds) {
    return sportIds.stream()
        .map(SportSpecialization::new)
        .collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public SportType getSportType() {
    return sportType;
  }

  public String getDescription() {
    return description;
  }
}
