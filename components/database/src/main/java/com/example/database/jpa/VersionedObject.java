/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import com.example.database.Identifiable;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import org.hibernate.annotations.TypeDef;

/**
 * A JPA mapped super class that can be used for all tables that use a version column for
 * concurrency control.
 */
@TypeDef(name = "json", typeClass = JsonStringType.class)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@MappedSuperclass
public abstract class VersionedObject<T> implements Identifiable<T> {

  @Version
  @Column(name = "version")
  protected Integer version;

  /**
   * Get the current version of the object.
   *
   * @return The version number of the row.
   */
  public Integer getVersion() {
    return this.version;
  }
}
