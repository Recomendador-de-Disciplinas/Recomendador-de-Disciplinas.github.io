import axios from 'axios';

console.log('AQUI: ' + process.env.BACKEND_URL);
const axiosClient = axios.create({
  baseURL: process.env.BACKEND_URL || 'http://localhost:8080',
});

export default axiosClient;
