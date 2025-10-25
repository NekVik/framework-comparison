package ru.otus.comparison.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Operation;

@Controller("/users")
public class HelloController {

    @Operation(summary = "Приветствие", description = "Приветствие")
    @Get("/hello")
    public String hello() {
        return "Привет!";
    }

}

