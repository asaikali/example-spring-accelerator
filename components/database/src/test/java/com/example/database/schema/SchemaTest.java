/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.database.test.TransactionalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("Test Database Schema Management")
class SchemaTest extends TransactionalTest {

  @Test
  @DisplayName("On Startup all schemas have been created")
  void testModuleSchemaMigrated(@Autowired SchemaManager schemaManager) {
    assertThat(schemaManager.getSchemas().size()).isEqualTo(2);
    assertThat(count("foo.flyway_schema_history")).isEqualTo(2);
    assertThat(count("bar.flyway_schema_history")).isEqualTo(1);
    assertThat(count("flyway_schema_history")).isZero();
  }

  @Test
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  @DisplayName("A schema can be rebuilt on demand")
  void testSchemaRebuild(
      @Autowired FooSchema fooSchema, @Autowired SchemaManagerImpl schemaManager) {
    // Given
    assertThat(count("foo.test")).isEqualTo(1);
    assertThat(fooSchema.getName()).isEqualTo("foo");
    txUtils.required(() -> jdbcTemplate.update("INSERT INTO foo.test (name) VALUES ('jim')"));
    assertThat(count("foo.test")).isEqualTo(2);

    // When
    schemaManager.rebuild(fooSchema);

    // Then
    assertThat(count("foo.test")).isEqualTo(1);
  }
}
