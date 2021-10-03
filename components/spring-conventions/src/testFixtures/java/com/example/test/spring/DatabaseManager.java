/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.test.spring;

public interface DatabaseManager {

  void dropSchemas();

  void rebuildSchemasAndLoadTestData();
}
