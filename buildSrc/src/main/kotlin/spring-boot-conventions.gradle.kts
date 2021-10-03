import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}

tasks.getByName<BootJar>("bootJar") {
    archiveBaseName.set(project.path.replace(":","-").substring(1))
}
