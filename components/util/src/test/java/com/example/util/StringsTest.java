/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String utilities test")
class StringsTest {

  @Test
  void testIsAlphaNumeric() {
    Assertions.assertThat(Strings.isAlphaNumeric(null)).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("abc@def")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric(" ")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("+++")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric(" A")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("A ")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("\nA")).isFalse();
    Assertions.assertThat(Strings.isAlphaNumeric("A")).isTrue();
    Assertions.assertThat(Strings.isAlphaNumeric("bA")).isTrue();
    Assertions.assertThat(Strings.isAlphaNumeric("9bA1")).isTrue();
  }
}
