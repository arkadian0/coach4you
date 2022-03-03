package com.example.coach4you.adapter.api.request;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreateCoachRequest(@NotEmpty String firstName, @NotEmpty String lastName,
                                 @NotEmpty @Email String email, @NotNull short age,
                                 @NotEmpty String yearsOfExperience, @NotEmpty String description,
                                 @NotNull Set<Long> sportIds,
                                 @NotNull Set<Long> activityIds,
                                 @NotNull Set<String> professions) {
}
