/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.test.spring;

import com.example.time.TimeMachine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;

/**
 * A base class for tests that need spring configured. It activates a the test profile and it
 * configured a mutable clock that be manipulated via TimeMachine class to make it easy to do tests
 * of business logic that need to validate behaviour that depends on time.
 */
@ActiveProfiles(TestProfile.NAME)
public abstract class SpringTest {

  @Autowired protected TimeMachine timeMachine;

  @BeforeEach
  void rebuildDatabase(@Autowired DatabaseManager databaseManager) {
    databaseManager.rebuildSchemasAndLoadTestData();
  }

  @BeforeAll
  @AfterAll
  static void cleanDatabase(@Autowired DatabaseManager databaseManager) {
    databaseManager.dropSchemas();
  }

  /**
   * Creates a classpath resource that points to a file on the classpath that is located in a
   * specific package.
   *
   * @param p the package that the file is in
   * @param fileName the name of the file in the package
   * @return classpath resource that can be used to read the file
   */
  protected ClassPathResource classPathResource(Package p, String fileName) {
    var path = p.getName().replace(".", "/") + "/" + fileName;
    return new ClassPathResource(path);
  }

  /**
   * Creates a classpath resource that points to the file that is located in the same package as the
   * specified class.
   *
   * @param c the class who's package the file should be in
   * @param fileName the name of the name
   * @return classpath resource that can be used to read the file
   */
  protected ClassPathResource classPathResource(Class c, String fileName) {
    return classPathResource(c.getPackage(), fileName);
  }
}
