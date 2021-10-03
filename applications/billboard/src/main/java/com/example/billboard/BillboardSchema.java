/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import com.example.database.schema.Schema;
import org.springframework.stereotype.Component;

@Component
class BillboardSchema implements Schema {

  @Override
  public String getName() {
    return "billboard";
  }
}
