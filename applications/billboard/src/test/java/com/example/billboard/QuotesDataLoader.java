/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import com.example.database.test.TestDataLoader;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
class QuotesDataLoader implements TestDataLoader {

  private final QuoteRepository quoteRepository;

  QuotesDataLoader(QuoteRepository quoteRepository) {
    this.quoteRepository = quoteRepository;
  }

  @Override
  public String getSchema() {
    return "billboard";
  }

  @Override
  @Transactional
  public void loadData() {
    var quote = new Quote();
    quote.setAuthor("Winston Churchill");
    quote.setQuote("Never, never, never give up");
    quoteRepository.save(quote);
  }
}
