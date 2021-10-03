plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

val bootVersion = file("src/main/resources/springBootVersion.txt").readText().trim()

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:4.5.1" )
    implementation("gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:2.2.2")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${bootVersion}")
}
