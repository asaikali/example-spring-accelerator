/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.test;

import com.example.test.spring.TestProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestProfile
@Configuration
class DatabaseTestFixturesConfiguration {

  @Bean
  TxUtils txUtils() {
    return new TxUtils();
  }
}
