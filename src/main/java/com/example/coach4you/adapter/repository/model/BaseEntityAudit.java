package com.example.coach4you.adapter.repository.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {

  private String createdBy;
  private String updatedBy;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime updatedAt;

  /**
   * Sets createdAt before insert
   */
  @PrePersist
  public void setCreationDate() {
    this.createdAt = LocalDateTime.now();
  }

  /**
   * Sets updatedAt before update
   */
  @PreUpdate
  public void setChangeDate() {
    this.updatedAt = LocalDateTime.now();
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    BaseEntityAudit that = (BaseEntityAudit) o;
    return Objects.equals(createdBy, that.createdBy) &&
        Objects.equals(updatedBy, that.updatedBy) &&
        Objects.equals(createdAt, that.createdAt) &&
        Objects.equals(updatedAt, that.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), createdBy, updatedBy, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "BaseEntityAudit{" +
        "createdBy='" + createdBy + '\'' +
        ", updatedBy='" + updatedBy + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "} " + super.toString();
  }
}