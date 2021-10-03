/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * A JPA mapped super class that can be used for all tables defined in the database that use a UUID
 * as the primary key.
 *
 * <p>All tables in the database are expected to have an integer version number, for these tables to
 * be mapped from JPA.
 *
 * <p>The primary key should always be called id
 *
 * <p>The version column is expected to be an integer column that is always auto incremented on
 * every update to the row.
 */
@MappedSuperclass
public abstract class UniquePersistableObject extends TimeStampedObject<UUID> {

  @Id
  @Column(name = "id")
  protected UUID id;

  /**
   * Get the database UUID of this object.
   *
   * @return The primary key of the row.
   */
  @Override
  public UUID getId() {
    return this.id;
  }

  /**
   * Set the primary key of this object.
   *
   * @param id the UUID to the primary key to.
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Set the primary key of this object.
   *
   * @param id the String UUID to the primary key to.
   */
  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  /** Set the primary key of this object using a randomly generated UUID. */
  public UUID setRandomId() {
    UUID uuid = UUID.randomUUID();
    setId(uuid);
    return uuid;
  }
}
