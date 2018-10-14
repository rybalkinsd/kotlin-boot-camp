import org.gradle.internal.impldep.aQute.bnd.osgi.Analyzer
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "io.rybalkinsd"
version = "1.0-SNAPSHOT"

plugins {
    val ktVersion = "1.2.71"
    kotlin("jvm") version ktVersion

    // spring-related
    id("org.jetbrains.kotlin.plugin.spring") version ktVersion
    id("org.springframework.boot") version "2.0.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.5.RELEASE"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    jcenter()
    mavenCentral()
}

val ktlint by configurations.creating

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compile("io.github.rybalkinsd", "kohttp", "0.3.1")
    compile("org.slf4j", "slf4j-api", "1.7.25")

    compile(spring("web"))
    compile(spring("actuator"))

    testCompile("junit", "junit", "4.12")
    testCompile(spring("test"))

    ktlint("com.github.shyiko", "ktlint", "0.28.0")
}

tasks {
    val ktlint by creating(JavaExec::class) {
        group = "verification"
        description = "Check Kotlin code style."
        main = "com.github.shyiko.ktlint.Main"
        classpath = ktlint
        args = listOf("src/**/*.kt")
    }

    "check" {
        dependsOn(ktlint)
    }
}

fun DependencyHandler.spring(module: String, version: String? = null) =
    "org.springframework.boot:spring-boot-starter-$module${version?.let { ":$version" } ?: ""}"
