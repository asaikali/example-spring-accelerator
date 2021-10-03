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
class PersistableObjectTest extends TransactionalTest {

  @Autowired private PersistableRepository repository;

  @Test
  void testSave() {
    // Given
    Persistable adib = new Persistable();
    adib.setName("Adib");

    // When
    repository.save(adib);
    repository.flush();

    // Then
    assertThat(adib.getId()).isNotNull();
    assertThat(adib.getVersion()).isZero();
    assertThat(adib.getInsertTimestamp()).isNotNull();
    assertThat(adib.getInsertTimestamp()).isEqualTo(adib.getUpdateTimestamp());
    assertThat(adib.getInsertTimestamp()).isBefore(Instant.now());

    // When
    Persistable neven = repository.findById(adib.getId()).get();
    neven.setName("Neven");
    repository.flush();

    // Then
    assertThat(neven.getVersion()).isEqualTo(1);
  }
}
