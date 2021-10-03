/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.database.test.TransactionalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class QuotesRepositoryTest extends TransactionalTest {

  @Test
  @DisplayName("A random quote is returned")
  void testRandomQuotes(@Autowired QuoteRepository quoteRepository) {
    var quote = quoteRepository.findRandomQuote();
    assertThat(quote).isNotNull();
  }
}
