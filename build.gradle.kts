import org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel


plugins {
    idea
    id("io.spring.dependency-management")
    id("org.springframework.boot") apply false
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(21)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

allprojects {
    group = "ru.otus"
    version = "0.0.1-SNAPSHOT"
    description = "Итоговый проект курса Otus"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    val testcontainersBom: String by project
    val springDocOpenapiUi: String by project
    val mapstructVersion: String by project


    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            imports {
                mavenBom(BOM_COORDINATES)
                mavenBom("org.testcontainers:testcontainers-bom:$testcontainersBom")
            }

            dependency("io.swagger.core.v3:swagger-annotations:2.1.10")
            dependency("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocOpenapiUi")
            dependency("org.mapstruct:mapstruct:$mapstructVersion")
            dependency("org.mapstruct:mapstruct-processor:$mapstructVersion")
        }
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }
}

subprojects {
    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-parameters", "-Xlint:all,-serial,-processing"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging.showExceptions = true
        reports {
            junitXml.required.set(true)
            html.required.set(true)
        }
    }

}