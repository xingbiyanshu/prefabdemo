plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.sissi.lab.klog"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        externalNativeBuild {
            cmake {
                arguments +="-DANDROID_STL=none"
            }
        }
        ndk {
            abiFilters += "arm64-v8a"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildFeatures {
        prefabPublishing = true
    }

    prefab {
        create("klog"){
            headers="src/main/cpp"
        }
    }

}

dependencies {

}


publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.sissi.lab"
            artifactId = "klog"
            version = "1.0"

            afterEvaluate {
                from(components["release"])
            }
        }

    }
    repositories {
        maven {
            name="myrepo"
            url = uri("${rootProject.projectDir}/build/repository")
        }
    }
}
