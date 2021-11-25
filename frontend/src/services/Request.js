import axios from '@/plugins/axios';

export async function fetchDataFromBackend(path, body = {}) {
  const params = new URLSearchParams();
  Object.keys(body).forEach((key) => {
    params.append(key, body[key]);
  });

  const response = await axios.get(path, {
    params,
  });

  if (response.status === 200) {
    return response.data;
  }
  return null;
}
