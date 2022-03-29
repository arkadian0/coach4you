package com.example.coach4you.adapter.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.coach4you.adapter.repository.model.CoachDbModel;
import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.service.CoachFactory;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoachJpaRepositoryAdapterTest {

  @Mock
  private CoachJpaRepository coachJpaRepository;

  @InjectMocks
  private CoachJpaRepositoryAdapter coachJpaRepositoryAdapter;

  @Test
  void should_correct_get_coach() {
    //given
    var coachId = 1L;
    CoachDbModel foundedCoachDb = CoachFactory.getCoachDbModel();
    when(coachJpaRepository.findById(coachId)).thenReturn(Optional.of(foundedCoachDb));

    //when
    Optional<Coach> coach = coachJpaRepositoryAdapter.getCoachById(coachId);

    //then
    assertThat(coach.isPresent()).isTrue();
    assertThat(coach.get().getId()).isEqualTo(foundedCoachDb.getId());
    assertThat(coach.get().getPersonDetails().getFirstName()).isEqualTo(foundedCoachDb.getFirstName());
    assertThat(coach.get().getPersonDetails().getLastName()).isEqualTo(foundedCoachDb.getLastName());
    assertThat(coach.get().getPersonDetails().getEmail()).isEqualTo(foundedCoachDb.getEmail());
    assertThat(coach.get().getPersonDetails().getAge()).isEqualTo(foundedCoachDb.getAge());
    assertThat(coach.get().getPersonDetails().getAge()).isEqualTo(foundedCoachDb.getAge());
    assertThat(coach.get().getDescription()).isEqualTo(foundedCoachDb.getDescription());
    assertThat(coach.get().getYearsOfExperience()).isEqualTo(foundedCoachDb.getYearsOfExperience());
    assertThat(coach.get().getProfessionSpecialization().getProfessionsAsString()).isEqualTo(foundedCoachDb.getProfessions());
    assertThat(coach.get().getActivitySpecializations().get(0).getActivityType()).isEqualTo(foundedCoachDb.getActivityDictionaries().get(0).getCode());
    assertThat(coach.get().getActivitySpecializations().get(0).getDescription()).isEqualTo(foundedCoachDb.getActivityDictionaries().get(0).getDescription());
    assertThat(coach.get().getActivitySpecializations().get(0).getId()).isEqualTo(foundedCoachDb.getActivityDictionaries().get(0).getId());
    assertThat(coach.get().getSportSpecializations().get(0).getId()).isEqualTo(foundedCoachDb.getSportDictionaries().get(0).getId());
    assertThat(coach.get().getSportSpecializations().get(0).getSportType()).isEqualTo(foundedCoachDb.getSportDictionaries().get(0).getCode());
    assertThat(coach.get().getSportSpecializations().get(0).getDescription()).isEqualTo(foundedCoachDb.getSportDictionaries().get(0).getDescription());
  }

  @Test
  void should_get_empty_coach() {
    //given
    var coachId = 1L;
    when(coachJpaRepository.findById(coachId)).thenReturn(Optional.empty());

    //when
    Optional<Coach> coach = coachJpaRepositoryAdapter.getCoachById(coachId);

    //then
    assertThat(coach.isPresent()).isFalse();
  }

}