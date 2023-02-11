plugins {
    id(Dependencies.Plugin.multiplatformComposeSetup)
    id(Dependencies.Plugin.androidSetup)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))
            }
        }
    }
}