/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import com.example.database.jpa.PersistableObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "quotes", schema = "billboard")
public class Quote extends PersistableObject {

  @Column(name = "quote")
  private String quote;

  @Column(name = "author")
  private String author;

  public String getQuote() {
    return quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
