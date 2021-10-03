/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.time;

import com.example.test.spring.TestProfile;
import java.time.Instant;
import java.time.ZoneOffset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.threeten.extra.MutableClock;

@Configuration
@TestProfile
@AutoConfigureBefore(ClockConfiguration.class)
class TestClockConfiguration {
  private final Logger logger = LoggerFactory.getLogger(TestClockConfiguration.class);

  @Bean
  MutableClock clock() {
    logger.warn("** ++ TestClockProvider with a Mutable Clock In Use ++ **");
    return MutableClock.of(Instant.now(), ZoneOffset.UTC);
  }

  @Bean
  TimeMachine timeMachine(MutableClock clock) {
    return new TimeMachine(clock);
  }
}
