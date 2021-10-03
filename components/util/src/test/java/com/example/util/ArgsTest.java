/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Argument validation utility")
class ArgsTest {

  @Test
  void testRequireTrue() {
    // should not throw exceptions
    Args.requireTrue(true, "the message");

    // should throw exceptions
    assertThatThrownBy(() -> Args.requireTrue(false, ""))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testNotNull() {
    // should not throw exceptions
    Args.notNull("");
    Args.notNull("", "the message");

    // should throw exceptions
    assertThatThrownBy(() -> Args.notNull(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notNull(null, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> Args.notNull(null, "the message")).hasMessage("the message");
  }

  @Test
  void testNotEmptyBooleanArray() {
    // should not throw exceptions
    boolean[] values = {true};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    boolean[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    boolean[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message")).hasMessage("message");
  }

  @Test
  void testNotEmptyByteArray() {
    // should not throw exceptions
    byte[] values = {1, 2, 4};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should  throw exceptions
    byte[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    byte[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .hasMessage("message")
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testNotEmptyCharArray() {
    // should not throw exceptions
    char[] values = {'c'};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    char[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    char[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testNotEmptyShortArray() {
    // should not throw exceptions
    short[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    short[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    short[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyIntArray() {
    // should not throw exceptions
    int[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    int[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    int[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyLongArray() {
    // should not throw exceptions
    long[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    long[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    long[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyFloatArray() {
    // should not throw exceptions
    float[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    float[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    float[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyDoubleArray() {
    // should not throw exceptions
    double[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    double[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    double[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyObjectArray() {
    // should not throw exceptions
    Object[] values = {1};
    Args.notEmpty(values);
    Args.notEmpty(values, "the message");

    // should throw exceptions
    Object[] nullArray = null;
    assertThatThrownBy(() -> Args.notEmpty(nullArray)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(nullArray, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    String[] emptyArray = {};
    assertThatThrownBy(() -> Args.notEmpty(emptyArray))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty(emptyArray, "message"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("message");
  }

  @Test
  void testNotEmptyString() {
    // should not throw exceptions
    Args.notEmpty("abc");
    Args.notEmpty("abc", "the message");

    // should throw exceptions
    assertThatThrownBy(() -> Args.notEmpty((String) null))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty((String) null, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> Args.notEmpty("")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notEmpty("", "the message")).hasMessage("the message");
  }

  @Test
  void testNotBlankString() {
    // should not throw exceptions
    Args.notBlank("this is not a blank string");
    Args.notBlank("this is not a blank string", "the message");

    // should throw exceptions
    String nullString = null;
    assertThatThrownBy(() -> Args.notBlank(nullString))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notBlank(nullString, "message"))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> Args.notBlank("  ")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> Args.notBlank("     ", "the message")).hasMessage("the message");
  }
}
