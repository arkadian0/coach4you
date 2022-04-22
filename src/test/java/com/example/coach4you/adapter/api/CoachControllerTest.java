package com.example.coach4you.adapter.api;

import com.example.coach4you.adapter.api.request.CreateCoachRequest;
import com.example.coach4you.adapter.api.request.UpdateCoachRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CoachControllerTest {

  private final long EXISTING_COACH_ID = 1L;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired private MockMvc mockMvc;

  @Test
  void mvc_should_create_and_fetch_coach() throws Exception {
    // given
    List<Long> sportSpecializationIds = List.of(1L, 2L);
    List<Long> activitySpecializationIds = List.of(1L, 2L);
    List<String> professionSpecializations = List.of("Coach", "Instructor");
    var createCoachRequest =
        new CreateCoachRequest(
            "Adrian",
            "Nowak",
            "adrian.nowak@gmail.com",
            (short) 25,
            "2-4",
            "Best coach ever seen",
            sportSpecializationIds,
            activitySpecializationIds,
            professionSpecializations);

    var request = objectMapper.writeValueAsString(createCoachRequest);

    // then
    MvcResult mvcResult =
        mockMvc
            .perform(post("/api/coaches").contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.coachId").exists())
            .andReturn();

    // then
    mockMvc
        .perform(
            get(
                    "/api/coaches/{coachId}",
                    new JSONObject(mvcResult.getResponse().getContentAsString()).getLong("coachId"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.coachId").exists())
        .andExpect(jsonPath("$.firstName").value(createCoachRequest.firstName()))
        .andExpect(jsonPath("$.lastName").value(createCoachRequest.lastName()))
        .andExpect(jsonPath("$.email").value(createCoachRequest.email()))
        .andExpect(jsonPath("$.age").value(String.valueOf(createCoachRequest.age())))
        .andExpect(jsonPath("$.yearsOfExperience").value(createCoachRequest.yearsOfExperience()))
        .andExpect(jsonPath("$.description").value(createCoachRequest.description()))
        .andExpect(jsonPath("$.professions[0]").value(professionSpecializations.get(0)))
        .andExpect(jsonPath("$.professions[1]").value(professionSpecializations.get(1)))
        .andExpect(jsonPath("$.sportSpecializations[0].id").value(sportSpecializationIds.get(0)))
        .andExpect(jsonPath("$.sportSpecializations[1].id").value(sportSpecializationIds.get(1)))
        .andExpect(
            jsonPath("$.activitySpecializations[0].id").value(activitySpecializationIds.get(0)))
        .andExpect(
            jsonPath("$.activitySpecializations[1].id").value(activitySpecializationIds.get(1)));
  }

  @Test
  void mvc_should_update_coach() throws Exception {
    // given
    List<Long> sportSpecializationIds = List.of(2L, 3L);
    List<Long> activitySpecializationIds = List.of(4L, 5L);
    List<String> professionSpecializations = List.of("Instructor", "Coach");
    var updateCoachRequest =
        new UpdateCoachRequest(
            "Damian",
            "Kowalczuk",
            "damian.kowalczuk@gmail.com",
                (short) 30,
            "4-5",
            "Best examples coach",
            sportSpecializationIds,
            activitySpecializationIds,
            professionSpecializations);

    var request = objectMapper.writeValueAsString(updateCoachRequest);

    // then
    MvcResult mvcResult =
        mockMvc
            .perform(
                put("/api/coaches/{coachId}", EXISTING_COACH_ID)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
            .andExpect(status().isCreated())
            .andReturn();

    // then
    mockMvc
        .perform(
            get("/api/coaches/{coachId}", EXISTING_COACH_ID)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.coachId").exists())
        .andExpect(jsonPath("$.firstName").value(updateCoachRequest.firstName()))
        .andExpect(jsonPath("$.lastName").value(updateCoachRequest.lastName()))
        .andExpect(jsonPath("$.email").value(updateCoachRequest.email()))
        .andExpect(jsonPath("$.age").value(String.valueOf(updateCoachRequest.age())))
        .andExpect(jsonPath("$.yearsOfExperience").value(updateCoachRequest.yearsOfExperience()))
        .andExpect(jsonPath("$.description").value(updateCoachRequest.description()))
        .andExpect(jsonPath("$.professions[0]").value(professionSpecializations.get(0)))
        .andExpect(jsonPath("$.professions[1]").value(professionSpecializations.get(1)))
        .andExpect(jsonPath("$.sportSpecializations[0].id").value(sportSpecializationIds.get(0)))
        .andExpect(jsonPath("$.sportSpecializations[1].id").value(sportSpecializationIds.get(1)))
        .andExpect(
            jsonPath("$.activitySpecializations[0].id").value(activitySpecializationIds.get(0)))
        .andExpect(
            jsonPath("$.activitySpecializations[1].id").value(activitySpecializationIds.get(1)));
  }
}
