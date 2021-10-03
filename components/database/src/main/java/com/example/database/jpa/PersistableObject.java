/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * A JPA mapped super class that can be used for all standard tables defined in the database that
 * use an auto incrementing long for the primary key.
 *
 * <p>All tables in the database are expected to have an Long surrogate primary key and an integer
 * version number, for these tables to be mapped from JPA.
 *
 * <p>The primary key should always be called id and it should be an auto increment long in the
 * range 1 to Long.MAX_VALUE
 *
 * <p>The version column is expected to be an integer column that is always auto incremented on
 * every update to the row.
 */
@MappedSuperclass
public abstract class PersistableObject extends TimeStampedObject<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;

  /**
   * Get the database generated id of the object.
   *
   * @return The primary key of the row.
   */
  @Override
  public Long getId() {
    return this.id;
  }
}
