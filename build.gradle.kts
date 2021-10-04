plugins {
    id("org.sonarqube") version "3.3"
}

sonarqube {
    properties {
        property("sonar.projectKey", "asaikali_example-spring-accelerator")
        property("sonar.organization", "asaikali")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
subprojects {

    repositories {
        mavenCentral()
    }

    group = "com.masteryway"
    version = "1.0.0"


}
