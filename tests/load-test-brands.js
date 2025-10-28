import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 100,
  iterations: 10000,
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95% запросов должны быть быстрее 500ms
    http_req_failed: ['rate<0.01'], // Меньше 1% ошибок
  },
};

export default function() {
  const baseUrl = __ENV.APP_URL;

  const response = http.get(`${baseUrl}/brands`);

  check(response, {
    'status is 200': (r) => r.status === 200,
    'response time < 500ms': (r) => r.timings.duration < 500,
    'has brands data': (r) => r.json().length > 0,
  });

  sleep(0.1);
}