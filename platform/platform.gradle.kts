plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:${Versions.SpringBootVersion}"))
    api(platform("org.testcontainers:testcontainers-bom:1.15.3"))
    constraints {
        api("org.seleniumhq.selenium:selenium-java:3.141.59")
        api("com.github.bbottema:emailaddress-rfc2822:2.1.4")
        api("com.icegreen:greenmail:1.5.11")
        api("nl.jqno.equalsverifier:equalsverifier:3.1.13")
        api("com.google.guava:guava:28.2-jre")
        api("org.threeten:threeten-extra:1.5.0")
        api("com.vladmihalcea:hibernate-types-52:2.9.7")
        api("io.rest-assured:rest-assured:4.3.1") {
            because("Spring Boot ships with Rest Assured 3.3 and I want to use the latest version")
        }
        api("org.codehaus.groovy:groovy:3.0.4") {
            because("Groovy 2.5 produces illegal access warnings in Java 11, 2.5 comes from spring boot dependencies")
        }
    }
}
