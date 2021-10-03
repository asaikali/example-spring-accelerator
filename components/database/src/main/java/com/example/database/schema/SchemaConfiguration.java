/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SchemaConfiguration {

  @Bean
  FlywayMigrationStrategy flywayMigrationStrategy(SchemaManager schemaManager) {
    return new MigrationStrategy(schemaManager);
  }

  @Bean
  SchemaManager schemaManager(List<Schema> schemas, DataSource dataSource) {
    return new SchemaManagerImpl(schemas, dataSource);
  }
}
