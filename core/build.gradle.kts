import org.jetbrains.kotlin.ir.backend.js.compile

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
        macosMain {
            dependencies {
                implementation("net.orandja.raylib:lib-macosarm64:0.0.0")
            }
            compilerOptions {
                val kotlinCommonCompilerOptions = this@compilerOptions
                freeCompilerArgs.addAll("-framework CoreVideo -framework IOKit -framework Cocoa -framework GLUT -framework OpenGL")
            }
        }
    }
}