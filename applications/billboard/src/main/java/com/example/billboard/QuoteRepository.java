/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

  @Query(
      nativeQuery = true,
      value =
          "SELECT id,quote,author,insert_ts,update_ts,version FROM billboard.quotes ORDER BY RANDOM() LIMIT 1")
  Quote findRandomQuote();
}
