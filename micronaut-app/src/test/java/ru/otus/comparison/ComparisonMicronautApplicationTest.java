package ru.otus.comparison;


import static org.junit.jupiter.api.Assertions.assertTrue;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


@Testcontainers
@MicronautTest
class ComparisonMicronautApplicationTest {

	@Container
	static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
		DockerImageName.parse("postgres:latest")
	)
		.withDatabaseName("demoDB")
		.withUsername("usr")
		.withPassword("pwd");

	@Inject
	EmbeddedApplication<?> application;

	static {
		postgres.start();
		// Переопределяем свойства для подключения к контейнеру
		System.setProperty("datasources.default.url", postgres.getJdbcUrl());
		System.setProperty("datasources.default.username", postgres.getUsername());
		System.setProperty("datasources.default.password", postgres.getPassword());
	}

	@Test
	void contextLoads() {
		assertTrue(application.isRunning());
	}
}