# Сравнение фреймворков Micronaut и SpringBoot

### Учебный проект, разработанный в рамках курса **Otus Java Developer Professional**

---

## Цели

- Создать приложение на Spring Boot для получения списка брэндов из БД Postgres
- В приложении использовать Spring JPA (Postgres), подключить Swagger, Flyway, Testcontainers
- Изучить и сделать такое же приложения на Micronaut (JPA, Swagger, Postgres)
- Упаковать приложения в Docker контейнеры и развернуть в docker
- Провести сравнение фрейморков через нагрузочное тестирование: k6, wrk, Apache Benchmark

---

## 🛠 Стек технологий

-	Java 21
-	Spring Boot 3.5.6
-	Spring Data JPA
-	OpenAPI, Swagger
-	PostgreSQL
-	Flyway — миграции
-	Testcontainers — интеграционные тесты
-	Docker — контейнеризация
-	Micronaut 4.9.4
-	Micronaut Hibernate JPA, OpenApi, Flyway

---

## Запуск (bash)

* Запустить приложения `docker compose up -d postgres spring-app micronaut-app`
* Проверка работы в Swagger: 
   * http://localhost:8070/swagger-ui/index.html
   * http://localhost:8071/swagger-ui/index.html
* Запуск тестов (bash) из корня (там где docker-compose)
<pre>
# используя k6
./run-load-test.sh   

# используя wrk
./run-wrk-test.sh

#используя Apache Bench
./run-ab-test.sh

</pre>
