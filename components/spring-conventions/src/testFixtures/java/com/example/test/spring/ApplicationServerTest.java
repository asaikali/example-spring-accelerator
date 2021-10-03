/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.test.spring;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import io.restassured.filter.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationPreprocessor;
import org.springframework.restdocs.operation.preprocess.UriModifyingOperationPreprocessor;
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation;

/**
 * Base class for tests that require a fully functional application server environment to test
 * against. The test methods in the derived classes are should send requests to the application,
 * they should not be interacting with the database directly, or via calling spring methods on
 * database objects or services.
 */
@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = "spring.main.banner-mode=log")
public abstract class ApplicationServerTest extends SpringTest {

  @LocalServerPort protected int localServerPort;

  @Autowired protected TestRestTemplate testRestTemplate;

  protected Filter restDocsFilter;

  @BeforeEach
  void setUpSpringRestDocs(RestDocumentationContextProvider restDocumentation) {
    var uriProcessor = this.springRestDocsUriProcessor();
    OperationPreprocessor[] operationPreprocessors;

    if (uriProcessor == null) {
      operationPreprocessors = new OperationPreprocessor[] {prettyPrint()};
    } else {
      operationPreprocessors = new OperationPreprocessor[] {uriProcessor, prettyPrint()};
    }

    this.restDocsFilter =
        RestAssuredRestDocumentation.documentationConfiguration(restDocumentation)
            .operationPreprocessors()
            .withRequestDefaults(operationPreprocessors)
            .withResponseDefaults(operationPreprocessors);
  }

  /**
   * Override this method if you want to have spring rest docs replace the URIS in requests and
   * responses to some other value.
   */
  protected UriModifyingOperationPreprocessor springRestDocsUriProcessor() {
    return null;
  }

  /** Returns the url that the server has been launched on. */
  protected String serverUrl() {
    return "http://localhost:" + localServerPort;
  }

  /**
   * takes a relative path turns it into an absolute URL.
   *
   * @param path the relative path to append to the server url
   * @return full url pointing to the server associated with this test
   */
  protected String serverUrl(String path) {
    if (path.startsWith("/")) {
      return serverUrl() + path;
    } else {
      return serverUrl() + "/" + path;
    }
  }
}
