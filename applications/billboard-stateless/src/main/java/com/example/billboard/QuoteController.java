/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.billboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class QuoteController {

  @GetMapping("/random-quote")
  Quote randomQuote() {
    var result = new Quote();
    result.setQuote("To be or not to be that is the question");
    result.setAuthor("William shakespeare");
    return result;
  }
}
