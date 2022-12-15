plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.12.0" )
    implementation("com.gorylenko.gradle-git-properties:gradle-git-properties:2.4.1")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.6")
}
