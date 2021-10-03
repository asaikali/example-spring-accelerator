/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.test.web;

import com.example.json.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

/** Utility class class for working with rest assured tests. */
public class RestAssuredClient {

  protected final String serverUrl;
  protected final RequestSpecBuilder requestSpecBuilder;
  protected final RestAssuredConfig restAssuredConfig;

  static {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  /**
   * Creates a rest client with a base uri of. The client is configured to log request and response
   * bodies if there is an assertion failure.
   *
   * @param serverUrl the url of the server to send requests to
   */
  public RestAssuredClient(String serverUrl) {
    this(serverUrl, null, (Filter[]) null);
  }

  /**
   * Creates a rest client with a base uri of. The client is configured to log request and response
   * bodies if there is an assertion failure.
   *
   * @param serverUrl the url of the server to send requests to
   * @param filters filters to add to the rest assured spec builder
   */
  public RestAssuredClient(String serverUrl, Filter... filters) {
    this(serverUrl, null, filters);
  }

  /**
   * Creates a rest client with a base uri of. The client is configured with the specifed
   * RestAssured configuration.
   *
   * @param serverUrl the url of the server to send requests to
   * @param config The rest assured configuration to use
   */
  public RestAssuredClient(String serverUrl, RestAssuredConfig config) {
    this(serverUrl, config, new Filter[0]);
  }

  /**
   * Creates a rest client with a base uri of. The client is configured with the specified
   * RestAssured configuration.
   *
   * @param serverUrl the url of the server to send requests to
   * @param config The rest assured configuration to use
   * @param filters filters to add to the rest assured spec builder
   */
  public RestAssuredClient(String serverUrl, RestAssuredConfig config, Filter... filters) {
    this.serverUrl = serverUrl;
    if (config == null) {
      this.restAssuredConfig = new RestAssuredConfig();
      this.restAssuredConfig
          .getLogConfig()
          .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    } else {
      this.restAssuredConfig = config;
    }
    this.requestSpecBuilder = new RequestSpecBuilder().setBaseUri(this.serverUrl).setConfig(config);
    for (int i = 0; i < filters.length; i++) {
      this.requestSpecBuilder.addFilter(filters[i]);
    }
  }

  /** Creates a request specification based on the request builder associated with the client. */
  public RequestSpecification given() {
    return RestAssured.given(requestSpecBuilder.build());
  }

  /**
   * Creates a request specification based on the request builder associated with the client, and
   * sets the request type to application/json.
   */
  public RequestSpecification jsonRequest() {
    return given().contentType("application/json");
  }

  /**
   * Creates a request specification based on the request builder associated with the client, and
   * sets the request type to application/json, and the request body to the serialized java object.
   *
   * @param object the object to serialize as as the json body of the request
   * @return the request specification
   */
  public RequestSpecification jsonRequest(Object object) {
    return jsonRequest().body(JsonUtils.toJson(object));
  }

  /** The server url, that set as the base uri of the rest assured client. */
  public String getServerUrl() {
    return serverUrl;
  }
}
