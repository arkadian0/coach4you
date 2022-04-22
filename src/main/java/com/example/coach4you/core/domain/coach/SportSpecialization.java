package com.example.coach4you.core.domain.coach;

import com.example.coach4you.core.domain.coach.enums.SportType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SportSpecialization {

  private Long id;
  private SportType sportType;
  private String description;

  public SportSpecialization(Long id) {
    this.id = id;
  }

  public static List<SportSpecialization> of(List<Long> sportIds) {
    return sportIds.stream().map(SportSpecialization::new).toList();
  }
}
