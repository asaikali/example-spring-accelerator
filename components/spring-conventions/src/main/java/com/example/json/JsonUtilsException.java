/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.json;

/** Indicates a problem when parsing or serializing JSON data. */
public class JsonUtilsException extends RuntimeException {

  public JsonUtilsException(String message, Throwable e) {
    super(message, e);
  }
}
