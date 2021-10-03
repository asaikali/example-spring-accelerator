/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import com.example.database.test.TestDataLoader;
import com.example.test.spring.DatabaseManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * A component to control the contents of a test database. It can be used to rebuild a database by
 * dropping all schemas, and recreating with flyway then reloading the database with content.
 */
class TestDatabaseManager implements DatabaseManager {
  private final Logger logger = LoggerFactory.getLogger(TestDatabaseManager.class);
  private final SchemaManagerImpl schemaManager;
  private final Map<String, Set<TestDataLoader>> loaders;
  private final JdbcTemplate jdbcTemplate;

  TestDatabaseManager(
      SchemaManagerImpl schemaManager,
      Optional<List<TestDataLoader>> optionalLoaders,
      JdbcTemplate jdbcTemplate) {
    this.schemaManager = schemaManager;
    this.jdbcTemplate = jdbcTemplate;
    this.loaders =
        optionalLoaders.orElse(List.of()).stream()
            .collect(Collectors.groupingBy(TestDataLoader::getSchema, Collectors.toSet()));
  }

  /** Destroy any schemas that this database manager knows about. */
  @Override
  public void dropSchemas() {
    logger.info("Start TestDatabaseManager.dropSchemas()");
    schemaManager
        .getSchemas()
        .forEach(
            schema -> {
              var sql = "DROP SCHEMA IF EXISTS " + schema.getName() + " CASCADE";
              logger.info("Dropping schema: " + sql);
              jdbcTemplate.execute(sql);
            });
    logger.info("Finish TestDatabaseManager.dropSchemas()");
  }

  /**
   * Rebuilds all schemas with Flyway and invokes all test test data loaders associated with a
   * schema.
   */
  @Override
  public void rebuildSchemasAndLoadTestData() {
    logger.info("Start TestDatabaseManager.rebuildSchemasAndLoadTestData()");
    for (Schema schema : schemaManager.getSchemas()) {
      schemaManager.rebuild(schema);
      var loader = loaders.get(schema.getName());
      if (loader != null) {
        loader.forEach(TestDataLoader::loadData);
      }
    }
    logger.info("End TestDatabaseManager.rebuildSchemasAndLoadTestData()");
  }
}
