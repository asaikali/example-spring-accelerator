/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unique_persistable", schema = "foo")
class UniquePersistable extends UniquePersistableObject {
  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
