package com.example.coach4you.adapter.repository.model;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.enums.ActivityType;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "activity_dictionary")
public class ActivityDictionaryDbModel extends BaseEntity{

  @Column(name = "code", nullable = false, length = 50, unique = true)
  private String code;

  @Column(name = "description", nullable = false, length = 50)
  private String description;

  public ActivityDictionaryDbModel() {
  }

  public static Set<ActivitySpecialization> toDomain(List<ActivityDictionaryDbModel> activityDictionaries) {
    return activityDictionaries.stream()
        .map(activity -> new ActivitySpecialization(ActivityType.valueOf(activity.getCode())))
        .collect(Collectors.toSet());
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
