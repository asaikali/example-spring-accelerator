plugins {
    `java-library-conventions`
    `java-test-fixtures-conventions`
}

dependencies {
    implementation(project(":components:util"))
    implementation(project(":components:spring-conventions"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    implementation("com.vladmihalcea:hibernate-types-52")
    runtimeOnly("org.postgresql:postgresql")

    testFixturesApi(testFixtures(project(":components:spring-conventions")))
}
