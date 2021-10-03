/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * A JPA mapped super class that can be used for all standard tables defined in the database that
 * have a creation time stamp and an update time stamp.
 */
@MappedSuperclass
public abstract class TimeStampedObject<T> extends VersionedObject<T> {
  @Column(name = "insert_ts")
  protected Instant insertTimestamp;

  @Column(name = "update_ts")
  protected Instant updateTimestamp;

  @PrePersist
  private void onInsert() {
    this.insertTimestamp = Instant.now();
    this.updateTimestamp = this.insertTimestamp;
  }

  @PreUpdate
  private void onUpdate() {
    this.updateTimestamp = Instant.now();
  }

  /**
   * Get the time when this object was inserted into the database. This field is automatically set
   * by JPA before an insert.
   *
   * @return The time when the row was created.
   */
  public Instant getInsertTimestamp() {
    return this.insertTimestamp;
  }

  /**
   * Get the time when this database row was updated was updated. The update timestamp is
   * automatically set by JPA on updates.
   *
   * @return The time when the row was last updated.
   */
  public Instant getUpdateTimestamp() {
    return this.updateTimestamp;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("{id: \"")
        .append(getId())
        .append("\", version: ")
        .append(getVersion())
        .append(", class: \"")
        .append(getClass().getName())
        .append("\"}")
        .toString();
  }
}
