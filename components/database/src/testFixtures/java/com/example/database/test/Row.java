/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.test;

import static com.example.util.Args.notBlank;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a fluent api to collect together a bunch of column names and and their vales,
 * for use with an insert statement methods.
 *
 * <p>{@code Row row = new Row("username", "jim@example.com").column("name", "Jim Smith");} <br>
 * {@code Integer pkey = insert("user_accounts",row,"pkey").getKey().intValue();}
 *
 * @see TransactionalTest#insert(String, Row)
 * @see TransactionalTest#insert(String, Row, String...)
 */
public class Row {

  public final Map<String, Object> map = new HashMap<>();

  private Row() {}

  public Row(String column, Object value) {
    this.map.put(notBlank(column), value);
  }

  public Row column(String column, Object value) {
    this.map.put(notBlank(column), value);
    return this;
  }
}
