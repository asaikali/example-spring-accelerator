plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.16.0" )
    implementation("com.gorylenko.gradle-git-properties:gradle-git-properties:2.3.1")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.5")
}
