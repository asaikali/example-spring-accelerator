/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.json;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Json Utilities Test")
class JsonUtilsTest {

  @Test
  @DisplayName("test formatting a json string")
  void testExceptions() {
    // test trying to read a badly formatted json object
    String input = "{\"a\":1,\"b\":\"foo\"";
    assertThatExceptionOfType(JsonUtilsException.class).isThrownBy(() -> JsonUtils.format(input));
  }

  @Test
  @DisplayName("test formatting a json string")
  void testFormatting() {
    // Given
    String unformatted = "{\"a\":1,\"b\":\"foo\"}";

    // When
    String formatted = JsonUtils.format(unformatted);

    // Then
    assertThat(formatted).isEqualTo("{\n" + "  \"a\" : 1,\n" + "  \"b\" : \"foo\"\n" + "}");
  }

  @Test
  @DisplayName("test serialization with common datatypes")
  void testCommonTypeSerializationAndDeserialization() {
    // given
    var simpleTypes = new SimpleTypes();
    simpleTypes.setDate(Date.from(Instant.parse("2020-02-02T19:58:24.203Z")));
    simpleTypes.setInstant(Instant.parse("2020-02-02T19:58:24.205720Z"));
    simpleTypes.setLocalDate(LocalDate.parse("2020-02-02"));
    simpleTypes.setLocalTime(LocalTime.parse("14:58:24.227038"));
    simpleTypes.setLocalDateTime(LocalDateTime.parse("2020-02-02T14:58:24.22708"));
    simpleTypes.setName("name");
    simpleTypes.setUuid(UUID.fromString("2efe835e-8079-458a-86ed-172af253c44b"));
    simpleTypes.setEmptyOptional(Optional.empty());
    simpleTypes.setFullOptional(Optional.of("test"));

    String input =
        "{\n"
            + "  \"name\" : \"name\",\n"
            + "  \"uuid\" : \"2efe835e-8079-458a-86ed-172af253c44b\",\n"
            + "  \"localDate\" : \"2020-02-02\",\n"
            + "  \"localTime\" : \"14:58:24.227038\",\n"
            + "  \"localDateTime\" : \"2020-02-02T14:58:24.22708\",\n"
            + "  \"instant\" : \"2020-02-02T19:58:24.205720Z\",\n"
            + "  \"date\" : \"2020-02-02T19:58:24.203+00:00\",\n"
            + "  \"emptyOptional\" : null,\n"
            + "  \"fullOptional\" : \"test\"\n"
            + "}";

    // when
    String json = JsonUtils.toJson(simpleTypes);
    SimpleTypes deserialized = JsonUtils.fromJson(input, SimpleTypes.class);

    // Then
    assertThat(json).isEqualTo(input);
    assertThat(deserialized).isEqualToComparingFieldByField(simpleTypes);
  }

  @Test
  @DisplayName("Test serializing a class that will generate an error")
  void serializationError() {
    Example e = new Example();
    e.name = "test";
    assertThatExceptionOfType(JsonUtilsException.class).isThrownBy(() -> JsonUtils.toJson(e));
  }

  static class Example {
    String name;
  }
}
