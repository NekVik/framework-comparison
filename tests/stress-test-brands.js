import http from 'k6/http';
import { check } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 20 },  // Разминка
    { duration: '1m', target: 50 },   // Средняя нагрузка
    { duration: '30s', target: 100 }, // Пиковая нагрузка
    { duration: '30s', target: 0 },   // Снижение
  ],
};

export default function() {
  const baseUrl = __ENV.APP_URL;

  const response = http.get(`${baseUrl}/brands`);

  check(response, {
    'status is 200': (r) => r.status === 200,
  });
}