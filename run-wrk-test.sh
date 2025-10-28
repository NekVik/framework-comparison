#!/bin/bash

echo "=== WRK Load Testing ==="

echo "Testing Spring Boot:"
docker compose run --rm wrk-load-test -t4 -c10000 -d10s http://spring-app:8070/brands

echo ""
echo "Testing Micronaut:"
docker compose run --rm wrk-load-test -t4 -c10000 -d10s http://micronaut-app:8071/brands