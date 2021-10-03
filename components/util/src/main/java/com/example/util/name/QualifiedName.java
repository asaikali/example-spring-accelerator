/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util.name;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents a fully qualified name made of words separated by dots. for example 'com.example.Foo'.
 * words can be any letters a-z or numbers 0-9 separated by dots.
 *
 * <p>a qualifier that must be a in reverse domain name format,
 */
public final class QualifiedName {
  private static final Pattern namePattern;

  static {
    namePattern = Pattern.compile("[\\w]+(\\.[\\w]+)+");
  }

  private final String name;

  /**
   * Create a qualified name based on the fully qualified name of this class.
   *
   * @param clazz the class that we want to use as the object name
   */
  public QualifiedName(Class<?> clazz) {
    this(clazz.getName());
  }

  /**
   * Ensures that the name is a fully qualified name otherwise throws an {@code
   * IllegalArgumentException}.
   *
   * @param name the fully qualified name
   * @throws IllegalArgumentException if the name is not valid
   */
  public QualifiedName(String name) {
    if (namePattern.matcher(name).matches()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Invalid qualified name '" + name + "'");
    }
  }

  /** Returns the fully qualified name. */
  public String getName() {
    return name;
  }

  /** Returns the qualifier portion of the name. */
  public String getQualifier() {
    return name.substring(0, name.lastIndexOf('.'));
  }

  /** Returns the unqualified name of the fully qualified name. */
  public String getUnqualifiedName() {
    return name.substring(name.lastIndexOf('.') + 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QualifiedName that = (QualifiedName) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
