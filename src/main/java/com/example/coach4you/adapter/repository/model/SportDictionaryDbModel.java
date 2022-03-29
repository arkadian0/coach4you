package com.example.coach4you.adapter.repository.model;

import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.domain.coach.enums.SportType;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@Table(name = "sport_dictionary")
public class SportDictionaryDbModel extends BaseEntity {

  @Enumerated(EnumType.STRING)
  @Column(name = "code", nullable = false, length = 50, unique = true)
  private SportType code;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public SportDictionaryDbModel() {
  }

  public static List<SportSpecialization> toDomain(List<SportDictionaryDbModel> sportDictionaries) {
    return sportDictionaries.stream()
        .map(sport -> new SportSpecialization(sport.getId(), sport.getCode(),
            sport.getDescription()))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SportDictionaryDbModel that = (SportDictionaryDbModel) o;
    return Objects.equals(code, that.code) && Objects
        .equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), code, description);
  }
}
