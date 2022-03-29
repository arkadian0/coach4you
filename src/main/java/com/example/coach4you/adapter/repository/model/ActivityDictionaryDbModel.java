package com.example.coach4you.adapter.repository.model;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.enums.ActivityType;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@Table(name = "activity_dictionary")
public class ActivityDictionaryDbModel extends BaseEntity {

  @Column(name = "code", nullable = false, length = 50, unique = true)
  @Enumerated(EnumType.STRING)
  private ActivityType code;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public ActivityDictionaryDbModel() {
  }

  public static List<ActivitySpecialization> toDomain(
      List<ActivityDictionaryDbModel> activityDictionaries) {
    return activityDictionaries.stream()
        .map(activity -> new ActivitySpecialization(activity.getId(),
            activity.getCode(), activity.getDescription()))
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
    ActivityDictionaryDbModel that = (ActivityDictionaryDbModel) o;
    return Objects.equals(code, that.code) && Objects
        .equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), code, description);
  }
}
