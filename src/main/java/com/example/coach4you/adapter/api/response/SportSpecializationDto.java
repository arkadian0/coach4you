package com.example.coach4you.adapter.api.response;

import com.example.coach4you.core.domain.coach.enums.SportType;

public record SportSpecializationDto(long id, SportType sportType, String description) {

}
