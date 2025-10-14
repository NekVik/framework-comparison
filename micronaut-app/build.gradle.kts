plugins {
    id("io.micronaut.application")
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut:micronaut-management")

    // Тестирование
    testImplementation("io.micronaut:micronaut-http-client")
}

application {
    mainClass.set("ru.otus.comparison.MicronautApplication")
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("ru.otus.*")
    }
}

tasks.jar {
    archiveFileName.set("micronaut-app.jar")
}