# backend

Example multi module spring boot project using gradle. 

# Tech Stack 

* Java 11 
* PostgreSQL 12
* Spring Boot 2.4 and it's ecosystem


# Conventions  

There are two types of gradle projects in this repo: components and applications. Components contain
reusable code useful across a range of applications. Component projects produce a .jar that can 
be used a dependency by other components or applications in this repo. all component projects 
must be located in the `components/` directory. 

# Classpath

All projects in this repo us the same version of Java, Spring Boot and other libraries. There is 
only one version of all dependencies across all component and applications in this repo. When you
upgrade a dependency you upgrade it for everything in this repo. This policy makes it easy to 
stay up to date with the latest versions of third party dependencies. 

## Gradle Build

Gradle with the Kotlin DSL is used for building the application. Build logic has been 
extracted into `buildSrc` as recommended by Gradle best practices. A gradle `java-platfrom` 
is used to align dependencies across all projects in this repo. Spring Boot BOM is used to manage
the classpath, but not the spring gradle plugin. 

The Spring boot version is set by editing `buildSrc/src/main/resources/springBootVersion.txt`. This 
is needed because the spring boot BOM and plugin are used, and it is easy to change the BOM 
version in the platform and forget to change the plugin version which can lead to bugs. Therefore,
the spring boot version is read from the value in `buildSrc/src/main/resources/springBootVersion.txt`.

## Code Formatting 

Code should be formatted using the Google java style guide. The Gradle spotless plugin ensures 
to make sure that the code formatting follows the standards. Spotless is configured to auto format
`.sql` file using dbBeaver. Code formatting violations cause the build to fail, but you can 
easily fix style issues automatically using `./gradlew  spotlessApply build`.

## Test fixtures 

This project uses the gradle [test fixtures plugin](https://docs.gradle.org/current/userguide/java_testing.html#sec:java_test_fixtures)
to enable each component to ship classes designed to make testing writing easier. 

## spring-conventions

If a project uses spring it must include the `spring-conventions` as a dependency. This project
contains a very small number of base classes and components that should always be on the classpath.
 
# Automated Testing Strategy

There are three types of tests with framework support. 
* Unit 
* Component 
* Integration 

## Unit Tests

Unit tests focus on testing a class in isolation with no external dependencies. This means no 
database, web container, or spring application context. The code being tested executes on the same 
thread running junit5 test methods. Unit tests make muse of the following frameworks. 

* [JUnit 5](https://junit.org/junit5/)
* [EqualsVerifier](https://jqno.nl/equalsverifier/)
* [AssertJ](https://joel-costigliola.github.io/assertj/index.html)
* [Mockito](https://site.mockito.org/)

## Transactional @Component Tests 

Component tests focus on testing a group of related classes within a spring application context,
with access to a PostgreSQL database, and MockMVC environment. A Tomcat server is not started, 
therefore the code being tested executes on the same thread running junit5 test methods. 
`@Transactional` tests can rollback at the end of the test method to restore database state to 
it's original condition. In addition to the unit testing frameworks component test make use of.

* [Spring TestContext](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html#testcontext-framework)
* [Spring MockMvc Test](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html#spring-mvc-test-framework)
* [Spring Boot Test](https://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/html/boot-features-testing.html)
* [Spring Security Test](https://docs.spring.io/spring-security/site/docs/5.3.0.RELEASE/reference/html5/#test-mockmvc)

### Web Environment 

`@SpringBootTest(webEnvironment = WebEnvironment.MOCK)` is used for executing tests. MockMvc Spring 
framework has some limitations any code that depends directly on servlet container will not work
for example error dispatching to send a request to the error page will not work. `@ControllerAdvice`
needs to be explicitly configured into the MockMVC environment, so does spring security filter
chain. 

### Database Test Data 

Loading data into the database can be done via `@Sql(scripts = path to .sql on classpath)` from
`org.springframework.test.context.jdbc.Sql` this will execute a data loading script as part of 
a test method or test class and rollback the transaction at the end of the test method. 

## Integration Application Server Tests

Integration tests focus on testing the backend by sending it requests over the network. Therefore,
a running Tomcat server and PostgreSQL server are required to run the integration tests. Test
methods in Junit are sending requests to tomcat and therefore the code under test is executing 
on the tomcat thread pool, therefore `@Transactional` tests will commit and it is not possible
to rollback a transactional test and restore the database to a well known state. In addition to 
the frameworks used by Unit and Component Tests, the following frameworks are also used.

* [REST-assured](http://rest-assured.io/)
* [Awaitility](https://github.com/awaitility/awaitility)


### Web Environment

`@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)` is used launch a fully functional
spring boot application on a random port for testing.


 

