package ru.otus.comparison;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Micronaut Application",
        version = "1.0",
        description = "Micronaut API для сравнения с Spring Boot"
    )
)
public class ComparisonMicronautApplication {

    public static void main(String[] args) {
        Micronaut.run(ComparisonMicronautApplication.class, args);
    }
}