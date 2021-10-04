/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Base class for tests that just need spring application context fully configured. Tomcat is not
 * started, rather a Spring MockMVC environment is available for testing.
 */
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, properties = "spring.main.banner-mode=log")
public abstract class ApplicationContextTest extends DatabaseTest {
  @Autowired protected MockMvc mockMvc;
}
