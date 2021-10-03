/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.database.schema;

import org.springframework.stereotype.Component;

@Component
class FooSchema implements Schema {
  @Override
  public String getName() {
    return "foo";
  }
}
