/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import java.util.List;

/**
 * Defines methods for managing a collection of schemas defined on the classpath, and picked up via
 * classpath scanning.
 */
public interface SchemaManager {

  /** Issues a Flyway migrate to migrate all the schemas picked up via Flyway classpath scanning. */
  void migrate();

  /** Returns a list of all Schema instances found via classpath scanning. */
  List<Schema> getSchemas();
}
