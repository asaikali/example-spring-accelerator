/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

class MigrationStrategy implements FlywayMigrationStrategy {

  private final SchemaManager schemaManager;

  public MigrationStrategy(SchemaManager schemaManager) {
    this.schemaManager = schemaManager;
  }

  @Override
  public void migrate(Flyway flyway) {
    schemaManager.migrate();
    flyway.migrate();
  }
}
