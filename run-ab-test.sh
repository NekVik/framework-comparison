#!/bin/bash

echo "=== Apache Bench Testing ==="

echo "Testing Spring Boot:"
docker compose run --rm ab-load-test -n 100000 -c 10 http://spring-app:8070/brands

echo ""
echo "Testing Micronaut:"
docker compose run --rm ab-load-test -n 100000 -c 10 http://micronaut-app:8071/brands