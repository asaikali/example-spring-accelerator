/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.test.spring;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;
import static org.testcontainers.containers.VncRecordingContainer.VncRecordingFormat.MP4;

import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Base class for running an in browser test using Selenium and test containers. A video of the run
 * will be written out
 */
@Testcontainers
@ContextConfiguration(initializers = BrowserTest.Initializer.class)
public class BrowserTest extends ApplicationServerTest {
  @Container
  protected BrowserWebDriverContainer<?> chrome =
      new BrowserWebDriverContainer<>()
          .withCapabilities(new ChromeOptions())
          .withRecordingMode(RECORD_ALL, new File("./build/"), MP4);

  @Override
  protected String serverUrl() {
    return "http://host.testcontainers.internal:" + this.localServerPort;
  }

  static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      applicationContext.addApplicationListener(
          (ApplicationListener<WebServerInitializedEvent>)
              event -> {

                /*
                 * When testing with Selenium WebDriver, chrome is running inside a docker
                 * container. SpringBoot app is running outside of docker on the docker host,
                 * therefore, you must allow the docker container running chrome to open a network
                 * connection to the host machine. Testcontainers.exposeHostPorts() must be called
                 * before the chrome container is launched by this Junit5 test. Therefore, we use
                 * a Spring ApplicationContextInitializer to configure Test Containers after Spring
                 * Boot has launched the app server but before any JUnit5 methods or configuration
                 * executes. From with a docker container launched by Test containers you can
                 * connect to the host docker machine via "http://host.testcontainers.internal"
                 */
                org.testcontainers.Testcontainers.exposeHostPorts(event.getWebServer().getPort());
              });
    }
  }
}
