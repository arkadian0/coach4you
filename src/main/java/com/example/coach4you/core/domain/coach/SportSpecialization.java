package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.coach.enums.SportType;
import java.util.Set;

public class SportSpecialization {

  private Long id;
  private SportType sportType;

  public SportSpecialization(SportType sportType) {
    this.sportType = sportType;
  }

  public static Set<SportSpecialization> of(Set<SportType> sportTypes) {
    return null;
  }

  public SportType getSportType() {
    return sportType;
  }
}
