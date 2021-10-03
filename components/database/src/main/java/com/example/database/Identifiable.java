/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database;

/**
 * A object that has a unique identity.
 *
 * @param <T> The type of object's identity
 */
public interface Identifiable<T> {

  /** Returns the value of the primary key. */
  T getId();
}
