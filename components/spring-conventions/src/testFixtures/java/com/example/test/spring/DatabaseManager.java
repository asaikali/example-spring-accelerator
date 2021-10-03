/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.test.spring;

/**
 * This class provides methods for manipulating database schemas, during tests. It enables tests to
 * rebuild schemas programmatically as part of a test execution, allowing test code to test various
 * edge cases.
 */
public interface DatabaseManager {

  void dropSchemas();

  void rebuildSchemasAndLoadTestData();
}
