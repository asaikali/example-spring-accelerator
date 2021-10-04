/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.billboard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

@DisplayName("In Browser Test")
class BillboardUiTest {
  @LocalServerPort protected int localServerPort;

  @Test
  @DisplayName("Test Home Page Loads Quotes")
  public void testHomePage() {}
}
