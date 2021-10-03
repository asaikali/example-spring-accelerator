/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class QuoteController {

  private final QuoteRepository quoteRepository;

  public QuoteController(QuoteRepository quoteRepository) {
    this.quoteRepository = quoteRepository;
  }

  @GetMapping("/random-quote")
  Quote randomQuote() {
    Quote result = quoteRepository.findRandomQuote();
    return result;
  }
}
