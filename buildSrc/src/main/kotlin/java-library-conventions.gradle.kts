plugins {
    `java-library`
    jacoco
    checkstyle
    id("com.diffplug.gradle.spotless")
    id("com.gorylenko.gradle-git-properties")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(platform(project(":platform")))
    implementation("org.springframework.boot:spring-boot-starter")
    api("com.google.guava:guava")
    testImplementation("nl.jqno.equalsverifier:equalsverifier")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.jar {
    // take the project path name and use it as the jar file name, for example a project
    // :shared:core generates a jar file shared-core-version.jar
    archiveBaseName.set(project.path.replace(":","-").substring(1))
}

tasks.test {
    //jvmArgs("--illegal-access=debug") // handy way to turn on tracking for illegal reflective access
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
    testLogging {
        showStandardStreams = false
        events("failed")
        showCauses = true
        showStackTraces = true
        setExceptionFormat("full")
    }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        xml.destination = file("${buildDir}/jacoco/test.xml")
        html.isEnabled = true
        html.destination = file("${buildDir}/jacoco/html")
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.1".toBigDecimal()
            }
        }
    }
}

tasks.compileJava {
    options.compilerArgs.add(element = "-parameters");
}

checkstyle {
    toolVersion = "8.32"
    configDirectory.set(rootProject.file("buildSrc/src/main/resources/checkstyle"))
    isShowViolations = true
    maxErrors = 0
    maxWarnings = 0
    isIgnoreFailures = false
}

spotless {
    java {
        googleJavaFormat()
        @Suppress("INACCESSIBLE_TYPE")
        licenseHeaderFile("${rootDir}/buildSrc/src/main/resources/spotless/template.license.java")
    }
    sql {
        target("**/*.sql")
        dbeaver().configFile("${rootDir}/buildSrc/src/main/resources/spotless/dbeaver.properties")
    }
}
