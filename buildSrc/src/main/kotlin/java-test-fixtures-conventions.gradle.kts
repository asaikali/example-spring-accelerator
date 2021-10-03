plugins {
    `java-library`
    `java-test-fixtures`
}

configurations {
    testFixturesImplementation {
        extendsFrom(configurations.implementation.get())
    }
}

dependencies {
    testFixturesImplementation("nl.jqno.equalsverifier:equalsverifier")
    testFixturesImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
