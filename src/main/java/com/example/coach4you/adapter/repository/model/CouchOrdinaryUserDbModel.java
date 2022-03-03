package com.example.coach4you.adapter.repository.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "coach_ordinary_user")
public class CouchOrdinaryUserDbModel {

  @EmbeddedId
  CouchOrdinaryUserKey id;

  @ManyToOne
  @MapsId("coachId")
  @JoinColumn(name = "coach_id")
  CoachDbModel coach;

  @ManyToOne
  @MapsId("ordinaryUserId")
  @JoinColumn(name = "ordinary_user_id")
  OrdinaryUserDbModel course;

}

@Embeddable
class CouchOrdinaryUserKey implements Serializable {

  @Column(name = "coach_id")
  Long coachId;

  @Column(name = "ordinary_user_id")
  Long ordinaryUserId;

}