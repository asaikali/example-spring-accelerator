/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util.name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("QualifiedName Tests")
class QualifiedNameTests {

  @Test
  @DisplayName("Invalid qualified names throw IllegalArgumentException")
  void invalidNames() {
    assertThatIllegalArgumentException().isThrownBy(() -> new QualifiedName(""));
    assertThatIllegalArgumentException().isThrownBy(() -> new QualifiedName("."));
    assertThatIllegalArgumentException().isThrownBy(() -> new QualifiedName("h"));
    assertThatIllegalArgumentException().isThrownBy(() -> new QualifiedName("foo"));
    assertThatIllegalArgumentException().isThrownBy(() -> new QualifiedName("foo.bar."));
  }

  @Test
  @DisplayName("Valid qualified names don't throw any exceptions")
  void validName() {
    assertThatCode(() -> new QualifiedName("a.b")).doesNotThrowAnyException();
    assertThatCode(() -> new QualifiedName("foo.bar.Baz")).doesNotThrowAnyException();
  }

  @Test
  @DisplayName("Can read parts of a qualified name")
  void readParts() {
    assertThat(new QualifiedName("a.b").getName()).isEqualTo("a.b");
    assertThat(new QualifiedName("a.b").getQualifier()).isEqualTo("a");
    assertThat(new QualifiedName("a.b").getUnqualifiedName()).isEqualTo("b");

    assertThat(new QualifiedName("a.b.c").getQualifier()).isEqualTo("a.b");
    assertThat(new QualifiedName("a.b.c").getUnqualifiedName()).isEqualTo("c");
  }

  @Test
  @DisplayName("Test equals & hashCode")
  void hashCodeEquals() {
    EqualsVerifier.forClass(QualifiedName.class).verify();
  }

  @Test
  @DisplayName("toString works")
  void toStringWorks() {
    assertThat(new QualifiedName("a.b")).hasToString("a.b");
  }
}
