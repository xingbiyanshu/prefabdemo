pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url=uri("${rootProject.projectDir}/build/repository"))
    }
}

rootProject.name = "PrefabDemo"
include(":app")
include(":klog")
include(":logwrapper")
