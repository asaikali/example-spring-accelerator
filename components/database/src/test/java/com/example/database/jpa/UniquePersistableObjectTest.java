/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.database.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.database.test.TransactionalTest;
import java.time.Instant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Test Persistable Objects with Long Primary keys Work")
class UniquePersistableObjectTest extends TransactionalTest {

  @Autowired private UniquePersistableRepository repository;

  @Test
  @DisplayName("Test various ways of setting id of a unique persistable object")
  void testSetIdVariations() {
    UniquePersistable persistable = new UniquePersistable();
    persistable.setRandomId();
    assertThat(persistable.getId()).isNotNull();
  }

  @Test
  @DisplayName("Test that common functionality on unique persistable objects work")
  void testCommonFields() {
    // Given
    String id = "bcf5dd8f-6bab-4a6d-8728-a2f0e26c272c";
    UniquePersistable adib = new UniquePersistable();
    adib.setName("Adib");
    adib.setId(id);

    // When
    repository.save(adib);
    repository.flush();

    // Then
    assertThat(adib.getId()).hasToString(id);
    assertThat(adib.getVersion()).isZero();
    assertThat(adib.getInsertTimestamp()).isNotNull();
    assertThat(adib.getInsertTimestamp()).isEqualTo(adib.getUpdateTimestamp());
    assertThat(adib.getInsertTimestamp()).isBefore(Instant.now());

    // When
    UniquePersistable neven = repository.findById(adib.getId()).get();
    neven.setName("Neven");
    repository.flush();

    assertThat(neven)
        .hasToString(
            "{id: \"bcf5dd8f-6bab-4a6d-8728-a2f0e26c272c\", version: 1, class: \"com.example.database.jpa.UniquePersistable\"}");

    // Then
    assertThat(neven.getVersion()).isEqualTo(1);
  }
}
