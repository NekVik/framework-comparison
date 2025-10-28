#!/bin/bash

set -e

echo "=== Load Testing Brands Endpoint ==="

echo ""
echo "=== Testing Spring Boot (8070) ==="
docker compose run --rm k6-load-test run load-test-brands.js -e APP_URL=http://spring-app:8070

echo ""
echo "=== Testing Micronaut (8071) ==="
docker compose run --rm k6-load-test run load-test-brands.js -e APP_URL=http://micronaut-app:8071

echo ""
echo "Load test completed!"