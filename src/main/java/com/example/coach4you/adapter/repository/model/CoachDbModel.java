package com.example.coach4you.adapter.repository.model;

import com.example.coach4you.core.domain.coach.ActivitySpecialization;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.domain.coach.ProfessionSpecialization;
import com.example.coach4you.core.domain.coach.SportSpecialization;
import com.example.coach4you.core.domain.user.PersonDetails;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "coach")
public class CoachDbModel extends BaseEntityAudit {

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @Column(name = "email", nullable = false, length = 70)
  private String email;

  @Column(name = "years_of_experience", nullable = false, length = 10)
  private String yearsOfExperience;

  @Column(name = "professions", nullable = false)
  private String professions;

  @Column(name = "description")
  private String description;

  @Column(name = "age", nullable = false)
  private Short age;

  @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinTable(
      name = "coach_activity_dictionary",
      joinColumns = {@JoinColumn(name = "coach_id")},
      inverseJoinColumns = {@JoinColumn(name = "activity_dictionary_id")}
  )
  List<ActivityDictionaryDbModel> activityDictionaries;

  @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinTable(
      name = "coach_sport_dictionary",
      joinColumns = {@JoinColumn(name = "coach_id")},
      inverseJoinColumns = {@JoinColumn(name = "sport_dictionary_id")}
  )
  List<SportDictionaryDbModel> sportDictionaries;

  public CoachDbModel() {
  }

  public static CoachDbModel of(Coach coach, List<ActivityDictionaryDbModel> activityDictionaries,
      List<SportDictionaryDbModel> sportDictionaries) {
    return CoachDbModel.builder()
        .description(coach.getDescription())
        .yearsOfExperience(coach.getYearsOfExperience())
        .firstName(coach.getPersonDetails().getFirstName())
        .lastName(coach.getPersonDetails().getLastName())
        .professions(coach.getProfessionSpecialization().getProfessionsAsString())
        .age(coach.getPersonDetails().getAge())
        .email(coach.getPersonDetails().getEmail())
        .activityDictionaries(activityDictionaries)
        .sportDictionaries(sportDictionaries)
        .build();
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
    CoachDbModel that = (CoachDbModel) o;
    return Objects.equals(firstName, that.firstName) && Objects
        .equals(lastName, that.lastName) && Objects.equals(email, that.email)
        && Objects.equals(yearsOfExperience, that.yearsOfExperience) && Objects
        .equals(description, that.description) && Objects.equals(age, that.age)
        && Objects.equals(activityDictionaries, that.activityDictionaries)
        && Objects.equals(sportDictionaries, that.sportDictionaries);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), firstName, lastName, email, yearsOfExperience, description, age,
            activityDictionaries, sportDictionaries);
  }

  public Coach toDomain() {
    PersonDetails personDetails = new PersonDetails(this.firstName, this.lastName,
        this.email, this.age);
    ProfessionSpecialization professionSpecialization = new ProfessionSpecialization(
       this.getProfessions());
    List<SportSpecialization> sportSpecializations = SportDictionaryDbModel
        .toDomain(this.getSportDictionaries());
    List<ActivitySpecialization> activitySpecializations = ActivityDictionaryDbModel
        .toDomain(this.getActivityDictionaries());
    return new Coach(this.id, personDetails, this.getYearsOfExperience(),
        this.getDescription(), professionSpecialization, sportSpecializations,
        activitySpecializations);
  }
}
