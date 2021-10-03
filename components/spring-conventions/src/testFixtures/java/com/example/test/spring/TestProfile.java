/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.test.spring;

import org.springframework.context.annotation.Profile;

/** Meta annotation to identify spring components that are are only indented for testing usage. */
@Profile(TestProfile.NAME)
public @interface TestProfile {
  String NAME = "test";
}
