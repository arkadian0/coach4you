package com.example.coach4you.adapter.api.response;

public record UpdateCoachResponse(Long coachId) {

  public static CreateCoachResponse of(long coachId) {
    return new CreateCoachResponse(coachId);
  }

}
