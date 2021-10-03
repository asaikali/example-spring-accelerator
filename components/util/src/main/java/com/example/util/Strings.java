/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

import java.util.regex.Pattern;

/** A collection of String utilities. */
public final class Strings {

  // for why anchoring patterns are explicitly set see https://stackoverflow.com/q/1894624/438319
  private static final Pattern alphaNumeric = Pattern.compile("^[a-zA-Z0-9]+$");

  private Strings() {}

  /**
   * Determine if a string is strictly alphanumeric. Blank and empty and null strings are not
   * considered alpha numeric.
   *
   * @param string the string to test
   * @return true if the string is alphanumeric, false otherwise
   */
  public static boolean isAlphaNumeric(String string) {
    return string != null && alphaNumeric.matcher(string).matches();
  }
}
