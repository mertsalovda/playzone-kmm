plugins {
    id(Dependencies.Plugin.multiplatformSetup)
    id(Dependencies.Plugin.androidSetup)
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "PlayZone iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            // isStatic = true
            baseName = "SharedSDK"

            export(project(":common:core"))
            export(project(":common:core-utils"))
//            export(project(":common:auth:api"))
            export(project(":common:auth:presentation"))
            export(project(":common:games:api"))
//            export(project(":common:games:presentation"))
//            export(project(":common:tournaments:api"))
//            export(project(":common:tournaments:presentation"))
            export(project(":common:umbrella-core"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
//            implementation(project(":common:auth:api"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:games:api"))
//            implementation(project(":common:games:presentation"))
//            implementation(project(":common:tournaments:api"))
//            implementation(project(":common:tournaments:presentation"))
                implementation(project(":common:umbrella-core"))
            }
        }

        iosMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:core-utils"))
//            api(project(":common:auth:api"))
                api(project(":common:auth:presentation"))
                api(project(":common:games:api"))
//            api(project(":common:games:presentation"))
//            api(project(":common:tournaments:api"))
//            api(project(":common:tournaments:presentation"))
                api(project(":common:umbrella-core"))
            }
        }
    }
}