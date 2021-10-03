/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

/**
 * Class with utility methods for validating arguments. All methods in this class will throw an
 * <code>IllegalArgumentException</code> if the condition they check for is false.
 */
public class Args {

  public static final String NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED =
      "null array or array of length 0 not allowed";

  private Args() {}

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in object is null.
   *
   * @param object to test for nullability
   */
  public static <T> T notNull(T object) {
    if (object == null) {
      throw new IllegalArgumentException("null is not allowed");
    }
    return object;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in object is null with the
   * specified message in the thrown exception.
   *
   * @param object to test for nullability
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static <T> T notNull(T object, String message) {
    if (object == null) {
      throw new IllegalArgumentException(message);
    }
    return object;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static byte[] notEmpty(byte[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static byte[] notEmpty(byte[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static char[] notEmpty(char[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static char[] notEmpty(char[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static short[] notEmpty(short[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static short[] notEmpty(short[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static int[] notEmpty(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static int[] notEmpty(int[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static long[] notEmpty(long[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static long[] notEmpty(long[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static float[] notEmpty(float[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static float[] notEmpty(float[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static double[] notEmpty(double[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static double[] notEmpty(double[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static boolean[] notEmpty(boolean[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static boolean[] notEmpty(boolean[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0.
   *
   * @param array array object to test is not null or has a length of 0
   */
  public static Object[] notEmpty(Object[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(NULL_ARRAY_OR_ARRAY_OF_LENGTH_0_NOT_ALLOWED);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in array is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param array array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static Object[] notEmpty(Object[] array, String message) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException(message);
    }
    return array;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in string is null or has a length
   * of 0.
   *
   * @param string string to test is not null or has a length of 0
   */
  public static String notEmpty(String string) {
    if (string == null || string.length() == 0) {
      throw new IllegalArgumentException("null string or string of length 0 not allowed");
    }
    return string;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in string is null or has a length
   * of 0 with the specified message in the thrown exception.
   *
   * @param string array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static String notEmpty(String string, String message) {
    if (string == null || string.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
    return string;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in string is null or is all white
   * space characters.
   *
   * @param string string to test is not null or has a length of 0
   */
  public static String notBlank(String string) {
    if (string == null || string.isBlank()) {
      throw new IllegalArgumentException("blank string not allowed");
    }
    return string;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed in string is null or is all
   * whitespace with the specified message in the thrown exception.
   *
   * @param string array object to test is not null or has a length of 0
   * @param message message to include in the thrown Illegal Arguments Exception
   */
  public static String notBlank(String string, String message) {
    if (string == null || string.isBlank()) {
      throw new IllegalArgumentException(message);
    }
    return string;
  }

  /**
   * throws an <code>IllegalArgumentException</code> if the passed is condition false.
   *
   * @param condition the condition that must be true
   * @param message message to included in the <code>IllegalArgumentException</code> that is thrown
   */
  public static void requireTrue(boolean condition, String message) {
    if (!condition) {
      throw new IllegalArgumentException(message);
    }
  }
}
