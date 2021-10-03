rootProject.name = "boot-test-fixtures"

include("platform")

// shared components
include(":components:util")
include(":components:spring-conventions")
include(":components:database")

// specific applications built on top of shared components
include(":applications:billboard")

fun setChildProjectsNames(parent: ProjectDescriptor) {
    parent.children.forEach { childProject ->
        childProject.buildFileName = "${childProject.name}.gradle.kts"
        setChildProjectsNames(childProject)
    }
}
setChildProjectsNames(rootProject);
