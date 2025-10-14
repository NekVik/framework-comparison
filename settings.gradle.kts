rootProject.name = "framework-comparison"

include("spring-app")
//include("micronaut-app")

pluginManagement {
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val micronautVersion: String by settings
    val jib: String by settings

    plugins {
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.google.cloud.tools.jib") version jib
        id("io.micronaut.application") version micronautVersion
    }
}