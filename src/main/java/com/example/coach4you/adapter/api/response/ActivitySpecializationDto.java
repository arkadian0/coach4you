package com.example.coach4you.adapter.api.response;

import com.example.coach4you.core.domain.coach.enums.ActivityType;

public record ActivitySpecializationDto(long id, ActivityType activityType, String description) {

}
