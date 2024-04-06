pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

buildscript {
    repositories { mavenCentral() }
    dependencies {
        classpath("net.orandja.ktm:core:1.0.3")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "raylib-as-kotlin-lib"

include(":core")
include(":lib")

