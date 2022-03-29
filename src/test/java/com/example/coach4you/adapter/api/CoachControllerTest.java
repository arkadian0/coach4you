package com.example.coach4you.adapter.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.coach4you.adapter.api.request.CreateCoachRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CoachControllerTest {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final static List<Long> EXISTING_SPORT_IDS = List.of(1L, 2L);
  private final static List<Long> EXISTING_ACTIVITY_IDS = List.of(1L, 2L);
  private final static long EXISTING_COACH_ID = 1L;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void mvc_should_create_coach() throws Exception {
    //given
    var createCoachRequest = new CreateCoachRequest("Adrian", "Nowak",
        "adrian.nowak@gmail.com", (short) 25, "2-4", "Best coach", EXISTING_SPORT_IDS,
        EXISTING_ACTIVITY_IDS, List.of("Coach, Instructor"));

    var request = objectMapper.writeValueAsString(createCoachRequest);

    // then
    mockMvc.perform(
        post("/api/coaches").contentType(MediaType.APPLICATION_JSON).content(request))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.coachId").exists());
  }

  @Test
  void mvc_should_fetch_coach() throws Exception {
    mockMvc.perform(
        get("/api/coaches/{coachId}", EXISTING_COACH_ID).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.coachId").exists())
        .andExpect(jsonPath("$.firstName").value("Ryszard"))
        .andExpect(jsonPath("$.lastName").value("Nowak"))
        .andExpect(jsonPath("$.email").value("ryszard.nowak@gmail.com"))
        .andExpect(jsonPath("$.age").value(30))
        .andExpect(jsonPath("$.yearsOfExperience").value("2-5"))
        .andExpect(jsonPath("$.description").value("Best coach ever seen"))
        .andExpect(jsonPath("$.professions[0]").value("Coach"))
        .andExpect(jsonPath("$.professions[1]").value("Instructor"))
        .andExpect(jsonPath("$.sportSpecializations[0].id").value(1))
        .andExpect(jsonPath("$.sportSpecializations[1].id").value(2))
        .andExpect(jsonPath("$.activitySpecializations[0].id").value(1))
        .andExpect(jsonPath("$.activitySpecializations[1].id").value(2));
  }

}


