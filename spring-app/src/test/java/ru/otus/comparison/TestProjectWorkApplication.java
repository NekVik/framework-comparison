package ru.otus.comparison;

public class TestProjectWorkApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.from(ComparisonSpringApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
