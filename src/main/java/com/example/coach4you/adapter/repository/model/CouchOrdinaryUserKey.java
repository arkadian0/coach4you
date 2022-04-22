package com.example.coach4you.adapter.repository.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class CouchOrdinaryUserKey implements Serializable {

  @Column(name = "coach_id")
  private Long coachId;

  @Column(name = "ordinary_user_id")
  private Long ordinaryUserId;
}
