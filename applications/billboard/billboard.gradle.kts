plugins {
    `java-library-conventions`
    `spring-boot-conventions`
}

springBoot {
    mainClassName = "example.DemoApplication"
}

dependencies {
    implementation(project(":components:util"))
    implementation(project(":components:database"))
    implementation(project(":components:spring-conventions"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("com.github.ben-manes.caffeine:caffeine")
    developmentOnly(platform(project(":platform")))
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.flywaydb:flyway-core")
    testImplementation("org.testcontainers:postgresql")
    testImplementation(testFixtures(project(":components:database")))
    testImplementation(testFixtures(project(":components:spring-conventions")))
    testRuntimeOnly("org.postgresql:postgresql")
}

