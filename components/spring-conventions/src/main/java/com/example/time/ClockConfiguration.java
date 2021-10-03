/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.time;

import java.time.Clock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(Clock.class)
class ClockConfiguration {
  @Bean
  Clock clock() {
    return Clock.systemUTC();
  }
}
