/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.json;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

class SimpleTypes {
  private String name;
  private UUID uuid;
  private LocalDate localDate;
  private LocalTime localTime;
  private LocalDateTime localDateTime;
  private Instant instant;
  private Date date;
  private Optional<String> emptyOptional;
  private Optional<String> fullOptional;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  public Instant getInstant() {
    return instant;
  }

  public void setInstant(Instant instant) {
    this.instant = instant;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Optional<String> getEmptyOptional() {
    return emptyOptional;
  }

  public void setEmptyOptional(Optional<String> emptyOptional) {
    this.emptyOptional = emptyOptional;
  }

  public Optional<String> getFullOptional() {
    return fullOptional;
  }

  public void setFullOptional(Optional<String> fullOptional) {
    this.fullOptional = fullOptional;
  }
}
