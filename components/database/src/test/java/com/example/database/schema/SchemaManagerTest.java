/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import com.example.database.test.TransactionalTest;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Schema Manager Test")
class SchemaManagerTest extends TransactionalTest {

  @Test
  @DisplayName("Schema names must be unique")
  void testSchemaNamesAreUnique(@Autowired DataSource dataSource) {
    assertThatIllegalStateException()
        .isThrownBy(
            () ->
                new SchemaManagerImpl(
                    List.of(new FooSchema(), new AnotherFooSchema()), dataSource));
  }

  @Test
  @DisplayName("Schema is not managed by schema manager")
  void testSchemaNamesAreUnique(@Autowired SchemaManagerImpl schemaMgr) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> schemaMgr.migrate(() -> "does not exist"));
  }

  private static class FooSchema implements Schema {
    @Override
    public String getName() {
      return "foo";
    }
  }

  private static class AnotherFooSchema implements Schema {
    @Override
    public String getName() {
      return "foo";
    }
  }
}
