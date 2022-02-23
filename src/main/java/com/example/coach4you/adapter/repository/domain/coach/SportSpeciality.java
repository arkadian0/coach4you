package com.example.coach4you.adapter.repository.domain.coach;

import com.example.coach4you.adapter.repository.domain.coach.enums.SportType;

public class SportSpeciality {

  private SportType sportType;

  public SportSpeciality(SportType sportType) {
    this.sportType = sportType;
  }

  public SportType getSportType() {
    return sportType;
  }
}
