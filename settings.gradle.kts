pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()    }

    plugins {
        kotlin("jvm").version(extra["kotlin.version"] as String)
        val kotlinVersion = extra["kotlin.version"] as String
        id("org.jetbrains.kotlin.plugin.compose").version(kotlinVersion)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
    }
}

rootProject.name = "small3"
