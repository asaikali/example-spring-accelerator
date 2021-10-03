plugins {
    `java-library-conventions`
    `java-test-fixtures-conventions`
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-json")

    testFixturesApi("org.seleniumhq.selenium:selenium-java")
    testFixturesApi("org.testcontainers:selenium:1.15.3")
    testFixturesApi("io.rest-assured:rest-assured")
    testFixturesApi("org.testcontainers:postgresql")
    testFixturesApi("org.testcontainers:junit-jupiter")
    testFixturesApi("org.springframework.restdocs:spring-restdocs-restassured")
    testFixturesImplementation("org.threeten:threeten-extra")
}
