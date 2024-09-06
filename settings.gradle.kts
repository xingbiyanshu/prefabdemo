pluginManagement {
    repositories {
//        maven(
//            url=uri("https://maven.aliyun.com/repository/gradle-plugin")
//        )
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        mavenLocal()
        google()
        mavenCentral()
        maven(url=uri("${rootProject.projectDir}/build/repository"))
    }
}

rootProject.name = "PrefabDemo"
include(":app")
include(":klog")
include(":logwrapper")
