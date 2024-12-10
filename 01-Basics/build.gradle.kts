plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

tasks.ktlintFormat {
    dependsOn(tasks.ktlintCheck)
}

ktlint {
    outputToConsole.set(true)
    android.set(false)
    outputColorName.set("RED")
    ignoreFailures.set(false)
}
