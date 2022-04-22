package com.example.coach4you.adapter.repository.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {

  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;

  @Column(name = "modification_date", nullable = false)
  private LocalDateTime modificationDate;

  /** Sets createDate before insert */
  @PrePersist
  public void setCreationDate() {
    this.createDate = LocalDateTime.now();
    this.modificationDate = LocalDateTime.now();
  }

  /** Sets modificationDate before update */
  @PreUpdate
  public void setChangeDate() {
    this.modificationDate = LocalDateTime.now();
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }

  public LocalDateTime getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(LocalDateTime modificationDate) {
    this.modificationDate = modificationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseEntityAudit that = (BaseEntityAudit) o;
    return Objects.equals(createDate, that.createDate)
        && Objects.equals(modificationDate, that.modificationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), createDate, modificationDate);
  }

  @Override
  public String toString() {
    return "BaseEntityAudit{"
        + "createDate="
        + createDate
        + ", modificationDate="
        + modificationDate
        + "} "
        + super.toString();
  }
}
