package com.example.coach4you.adapter.api;

import com.example.coach4you.adapter.api.request.CreateCoachRequest;
import com.example.coach4you.adapter.api.request.UpdateCoachRequest;
import com.example.coach4you.adapter.api.response.CreateCoachResponse;
import com.example.coach4you.adapter.api.response.GetCoachResponse;
import com.example.coach4you.adapter.api.response.UpdateCoachResponse;
import com.example.coach4you.core.port.command.CreateCoachCommand;
import com.example.coach4you.core.port.command.UpdateCoachCommand;
import com.example.coach4you.core.port.incoming.CoachServiceHandler;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coaches")
public class CoachController {

  private final CoachServiceHandler coachServiceHandler;

  @PostMapping
  public ResponseEntity<CreateCoachResponse> createCoach(
      @Valid @RequestBody final CreateCoachRequest request) {
    final CreateCoachCommand createCoachCommand =
        CreateCoachCommand.of(
            request.firstName(),
            request.lastName(),
            request.email(),
            request.age(),
            request.yearsOfExperience(),
            request.description(),
            request.sportIds(),
            request.activityIds(),
            request.professions());
    final var createdCoachId = coachServiceHandler.createCoach(createCoachCommand);
    return new ResponseEntity<>(CreateCoachResponse.of(createdCoachId), HttpStatus.CREATED);
  }

  @GetMapping("/{coachId}")
  public ResponseEntity<GetCoachResponse> getCoach(@PathVariable long coachId) {
    final var coach = coachServiceHandler.getCoach(coachId);
    return new ResponseEntity<>(GetCoachResponse.of(coach), HttpStatus.OK);
  }

  @PutMapping("/{coachId}")
  public ResponseEntity<UpdateCoachResponse> updateCoach(
      @PathVariable long coachId, @Valid @RequestBody final UpdateCoachRequest request) {
    final UpdateCoachCommand updateCoachCommand =
        UpdateCoachCommand.of(
            coachId,
            request.firstName(),
            request.lastName(),
            request.email(),
            request.age(),
            request.yearsOfExperience(),
            request.description(),
            request.sportIds(),
            request.activityIds(),
            request.professions());
    coachServiceHandler.updateCoach(updateCoachCommand);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
