/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.schema;

/**
 * A Schema is a collection of related database tables that are managed together by a single Flyway
 * instance. An application can have multiple schema's for different modules that make up the
 * application. All Schema instances that are defined as spring @Component are picked up the schema
 * {@link SchemaManager} which provides a way to collectively migrate all the schema that are part
 * of a single application. Database foreign key references between schemas are not allowed.
 */
public interface Schema {

  /**
   * Get the name name of the database schema. This will be used to issue a CREATE SCHEMA command.
   */
  String getName();
}
