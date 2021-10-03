/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.time;

import java.time.Duration;
import org.threeten.extra.MutableClock;

/**
 * A test only utility component that can be used to manipulate the clock used by the application
 * during tests. It can be used to move a clock forwards or backwards in time between method calls.
 */
public class TimeMachine {
  private final MutableClock clock;

  public TimeMachine(MutableClock clock) {
    this.clock = clock;
  }

  /**
   * Advanced the clock used by the application by a certain number of seconds.
   *
   * @param seconds the number of seconds to advance the clock by
   */
  public void advanceSeconds(long seconds) {
    this.clock.add(Duration.ofSeconds(seconds));
  }
}
