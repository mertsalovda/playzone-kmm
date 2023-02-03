plugins {
    id(Dependencies.Plugin.multiplatformSetup)
    id(Dependencies.Plugin.androidSetup)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
            }
        }
    }
}