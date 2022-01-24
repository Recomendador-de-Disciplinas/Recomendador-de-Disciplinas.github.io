import axios from 'axios';

const axiosClient = axios.create({
  console.log("AQUI: " + process.env.BACKEND_URL);
  baseURL: process.env.BACKEND_URL || 'http://localhost:8080',
});

export default axiosClient;
