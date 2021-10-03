/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SchemaManagerImpl implements SchemaManager {
  private final Logger logger = LoggerFactory.getLogger(SchemaManagerImpl.class);

  private final List<Schema> schemas;
  private final Map<String, Flyway> flyways;

  public SchemaManagerImpl(List<Schema> schemas, DataSource dataSource) {
    this.schemas = ImmutableList.copyOf(this.validateSchemaNameUniqueness(schemas));
    flyways =
        this.schemas.stream()
            .map(
                schema ->
                    Map.entry(
                        schema.getName(),
                        Flyway.configure()
                            .schemas(schema.getName())
                            .locations("db/" + schema.getName())
                            .dataSource(Objects.requireNonNull(dataSource))
                            .load()))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }

  @Override
  public List<Schema> getSchemas() {
    return schemas;
  }

  @Override
  public void migrate() {
    for (var schema : schemas) {
      migrate(schema);
    }
  }

  /**
   * package protected method to allow DatabaseManager to use to manage database state during
   * integration tests. Migrates the named schemas.
   *
   * @param schemas the specific schemas to migrate
   */
  void migrate(Schema... schemas) {
    for (var schema : schemas) {
      logger.info("Start migrating database schema '{}'", schema.getName());
      var flyway = this.flyways.get(schema.getName());
      if (flyway == null) {
        throw new IllegalArgumentException(
            String.format("Invalid schema '%s', not managed by SchemaManager", schema.getName()));
      }
      flyway.migrate();
      logger.info("Finish migrating database schema '{}'", schema.getName());
    }
  }

  /**
   * package protected method to allow DatabaseManager to use to manage database state during
   * integration tests. clean and then migrate the named schemas.
   *
   * @param schemas the specific schemas to clean and migrate
   */
  void rebuild(Schema... schemas) {
    this.clean(schemas);
    this.migrate(schemas);
  }

  private void clean(Schema... schemas) {
    for (var schema : schemas) {
      logger.warn("Start cleaning database schema '{}'", schema.getName());
      var flyway = this.flyways.get(schema.getName());
      if (flyway == null) {
        throw new IllegalArgumentException(
            String.format("Invalid schema '%s', not managed by SchemaManager", schema.getName()));
      }
      flyway.clean();
      logger.warn("Finish cleaning database schema '{}'", schema.getName());
    }
  }

  private List<Schema> validateSchemaNameUniqueness(List<Schema> schemas) {
    Set<String> schemaNames = new HashSet<>();
    for (var schema : schemas) {
      if (schemaNames.contains(schema.getName())) {
        throw new IllegalStateException("Duplicate schema name");
      }
      schemaNames.add(schema.getName());
    }
    return schemas;
  }
}
