rootProject.name = "example-spring-accelerator"

include("platform")

// shared components
include(":components:util")
include(":components:spring-conventions")
include(":components:database")

// specific applications built on top of shared components
include(":applications:billboard")
include(":applications:billboard-stateless")

fun setChildProjectsNames(parent: ProjectDescriptor) {
    parent.children.forEach { childProject ->
        childProject.buildFileName = "${childProject.name}.gradle.kts"
        setChildProjectsNames(childProject)
    }
}
setChildProjectsNames(rootProject);
