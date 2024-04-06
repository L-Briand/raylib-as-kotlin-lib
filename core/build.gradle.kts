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

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("test"))
            }
        }
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
    }
}