import net.orandja.ktm.Ktm
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

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

fun KotlinNativeTargetWithHostTests.addRaylibCinteropOnMain(name: String) {
    compilations.getByName("main").cinterops.create("raylib") {
        defFile(file("cinterop/$name/raylib.def"))
        packageName("raylib")
        compilerOpts("-I${file("cinterop/$name/raylib/include").absolutePath}")
    }
}

createDefFile("linuxX64")
createDefFile("mingwX64")
createDefFile("macOS")

kotlin {
    linuxX64 { addRaylibCinteropOnMain("linuxX64") }
    mingwX64 { addRaylibCinteropOnMain("mingwX64") }
    macosX64 { addRaylibCinteropOnMain("macOS") }
    macosArm64 { addRaylibCinteropOnMain("macOS") }
}

publishing {
    repositories {
        mavenLocal()
    }
}