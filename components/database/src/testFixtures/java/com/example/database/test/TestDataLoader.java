/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.test;

/**
 * Defines contract for test fixtures to load data into the database. The TestDataLoader is called
 * after the database schema is rebuilt.
 */
public interface TestDataLoader {

  /** Returns the schema name that this data loader can load data into. */
  String getSchema();

  /**
   * This method is called after a schema has been rebuilt to allow reloading of data for test
   * purposes.
   */
  void loadData();
}
