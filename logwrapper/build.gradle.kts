plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android") // publishing dsl block need this
    id("maven-publish")
}

android {
    namespace = "com.sissi.lab.logwrapper"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        externalNativeBuild {
            cmake {
                arguments +="-DANDROID_STL=none"
                cppFlags += "-fvisibility=hidden"
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
        prefab = true
        prefabPublishing = true
    }

    prefab {
        create("logwrapper"){
            headers="src/main/cpp"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.sissi.lab:klog:1.0")
}


publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.sissi.lab"
            artifactId = "logwrapper"
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
