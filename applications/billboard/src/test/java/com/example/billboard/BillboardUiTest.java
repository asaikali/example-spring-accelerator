/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.billboard;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.test.spring.BrowserTest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

@DisplayName("In Browser Test")
class BillboardUiTest extends BrowserTest {

  @Test
  @DisplayName("Test Home Page Loads Quotes")
  public void testHomePage() {
    RemoteWebDriver driver = chrome.getWebDriver();
    driver.get(serverUrl("/"));

    assertThat(driver.getTitle()).isEqualTo("Billboard");

    FluentWait<WebDriver> wait = new FluentWait<>(driver);
    wait.pollingEvery(Duration.ofSeconds(2));
    wait.withTimeout(Duration.ofSeconds(30));
    wait.ignoring(NoSuchElementException.class);

    List<String> messages = new ArrayList<>();

    wait.until(
        webDriver -> {
          WebElement element = webDriver.findElement(By.id("message"));
          String message = element.getText();
          messages.add(message);
          if (messages.size() >= 10) {
            return true;
          } else {
            return false;
          }
        });

    assertThat(messages)
        .containsAnyOf(
            "Failure is success in progress -- Anonymous",
            "Never, never, never give up -- Winston Churchill",
            "The shortest answer is doing -- Lord Herbert",
            "Success demands singleness of purpose -- Vincent Lombardi",
            "While there's life, there's hope -- Marcus Tullius Cicero");
  }
}
