import org.jetbrains.kotlin.ir.backend.js.compile
import org.jetbrains.kotlin.konan.target.linker

plugins {
    kotlin("multiplatform") version "2.0.0-Beta5"
}

group = "net.orandja.kmp"
version = "0.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    linuxX64 {
        binaries.executable {
            entryPoint = "main"
        }
    }
    mingwX64 {
        binaries.executable {
            entryPoint = "main"
        }
    }
    macosArm64 {
        binaries.executable {
            entryPoint = "main"
        }
    }

    sourceSets {
        linuxMain {
            dependencies {
                implementation("net.orandja.raylib:lib-linuxx64:0.0.0")
            }
        }
        mingwMain {
            dependencies {
                implementation("net.orandja.raylib:lib-mingwx64:0.0.0")
            }
        }
        getByName("macosArm64Main") {
            dependencies {
                implementation("net.orandja.raylib:lib-macosarm64:0.0.0")
            }
        }
    }
}