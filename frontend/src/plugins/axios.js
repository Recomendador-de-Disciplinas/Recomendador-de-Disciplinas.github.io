import axios from 'axios';

console.log('AQUI: ' + process.env.VUE_APP_BACKEND_URL);
const axiosClient = axios.create({
  baseURL: process.env.VUE_APP_BACKEND_URL || 'http://localhost:8080',
});

export default axiosClient;
