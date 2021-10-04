/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.test.spring;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A test that uses a SQL database, needs to be able to clear the database schema between test runs,
 * so that the state of the database is known.
 */
public abstract class DatabaseTest extends SpringTest {
  @BeforeEach
  void rebuildDatabase(@Autowired DatabaseManager databaseManager) {
    databaseManager.rebuildSchemasAndLoadTestData();
  }

  @BeforeAll
  @AfterAll
  static void cleanDatabase(@Autowired DatabaseManager databaseManager) {
    databaseManager.dropSchemas();
  }
}
