import net.orandja.ktm.Ktm

plugins {
    kotlin("multiplatform") version "2.0.0-Beta5"
    id("maven-publish")
}

group = "net.orandja.raylib"
version = "0.0.0"

repositories {
    mavenCentral()
}


fun createDefFile(platform: String) {
    file("cinterop/$platform/raylib.def").takeIf { !it.exists() }?.writer(Charsets.UTF_8)?.use {
        val defFileTemplate = file("raylib.def.template").readText()
        val libPath = file("cinterop/$platform/raylib/lib").absolutePath.replace("\\", "\\\\")
        it.write(String.format(defFileTemplate, libPath))
    }
}

createDefFile("linuxX64")
createDefFile("mingwX64")
createDefFile("macOS")

kotlin {
    linuxX64 {
        compilations.getByName("main").cinterops.create("raylib") {
            defFile(file("cinterop/linuxX64/raylib.def"))
            packageName("raylib")
            compilerOpts("-I${file("cinterop/linuxX64/raylib/include").absolutePath}")
        }
    }
    mingwX64 {
        compilations.getByName("main").cinterops.create("raylib") {
            defFile(file("cinterop/mingwX64/raylib.def"))
            packageName("raylib")
            compilerOpts("-I${file("cinterop/mingwX64/raylib/include").absolutePath}")
        }
    }
    macosArm64 {
        compilations.getByName("main").cinterops.create("raylib") {
            defFile(file("cinterop/macosArm64/raylib.def"))
            packageName("raylib")
            compilerOpts("-I${file("cinterop/macosArm64/raylib/include").absolutePath}")
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}