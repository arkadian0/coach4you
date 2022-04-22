package com.example.coach4you.core.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.coach4you.core.domain.coach.Coach;
import com.example.coach4you.core.exceptions.CoachNotFoundException;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.command.UpdateCoachCommand;
import com.example.coach4you.core.port.outgoing.CoachRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoachServiceTest {

  @Mock private CoachRepository coachRepository;

  @InjectMocks private CoachService coachService;

  @Test
  void should_correct_create_coach() throws Exception {
    // given
    var createCoachCommand =
        new CreateCoachCommand(
            "Adrian",
            "Nowak",
            "adrian.nowak@gmail.com",
            (short) 25,
            "2-40",
            "Best coach",
            List.of(1L, 2L),
            List.of(1L, 2L),
            List.of("Coach, Instructor"));
    var cratedCoachId = 111L;
    when(coachRepository.createCoach(any())).thenReturn(cratedCoachId);

    // when
    var coachId = coachService.createCoach(createCoachCommand);

    // then
    assertThat(coachId).isNotNull();
    assertThat(coachId).isEqualTo(cratedCoachId);
  }

  @Test
  void should_correct_get_coach() {
    // given
    var coachId = 1L;
    Coach foundedCoach = CoachFactory.getCoach();
    when(coachRepository.getCoachById(coachId)).thenReturn(Optional.of(foundedCoach));

    // when
    Coach coach = coachService.getCoach(coachId);

    // then
    assertThat(coach.getId()).isEqualTo(foundedCoach.getId());
  }

  @Test
  void should_throw_exception_when_coach_not_found() {
    // given
    var fakeLongId = 111L;
    when(coachRepository.getCoachById(fakeLongId)).thenReturn(Optional.empty());

    assertThatExceptionOfType(CoachNotFoundException.class)
        .isThrownBy(() -> coachService.getCoach(fakeLongId))
        .withMessage(String.format("Coach by id %s, not found", fakeLongId));
  }

  @Test
  void should_throw_exception_when_updated_coach_not_found() {
    // given
    var updateCoachCommand =
        new UpdateCoachCommand(
            111L,
            "Adrian",
            "Nowak",
            "adrian.nowak@gmail.com",
            (short) 25,
            "2-40",
            "Best coach",
            List.of(1L, 2L),
            List.of(1L, 2L),
            List.of("Coach, Instructor"));
    when(coachRepository.checkExists(updateCoachCommand.coachId())).thenReturn(false);

    // then
    assertThatExceptionOfType(CoachNotFoundException.class)
        .isThrownBy(() -> coachService.updateCoach(updateCoachCommand))
        .withMessage(String.format("Coach by id %s, not found", updateCoachCommand.coachId()));
  }
}
