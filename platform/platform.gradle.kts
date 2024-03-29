plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    api(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    api(platform("org.testcontainers:testcontainers-bom:1.17.6"))
    constraints {
        api("com.google.guava:guava:31.0-jre")
        api("org.threeten:threeten-extra:1.5.0")
        api("com.vladmihalcea:hibernate-types-52:2.12.0")
        api("com.github.bbottema:emailaddress-rfc2822:2.3.0")

        // testing dependencies
        api("com.icegreen:greenmail:1.6.5")
        api("nl.jqno.equalsverifier:equalsverifier:3.7.1")
        api("org.seleniumhq.selenium:selenium-java:3.141.59")
    }
}
