package com.example.coach4you.adapter.api.response;

public record CreateCoachResponse(Long coachId) {

  public static CreateCoachResponse of(long coachId) {
    return new CreateCoachResponse(coachId);
  }
}
