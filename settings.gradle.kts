rootProject.name = "framework-comparison"

include("spring-app")
include("micronaut-app")

pluginManagement {

    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val micronautPluginVersion: String by settings
    val gradleupShadowVersion: String by settings

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("io.micronaut.application") version micronautPluginVersion
        id("io.micronaut.aot") version micronautPluginVersion
        id("com.gradleup.shadow") version gradleupShadowVersion
    }

}