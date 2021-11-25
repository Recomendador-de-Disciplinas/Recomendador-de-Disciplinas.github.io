import axios from 'axios';

const axiosClient = axios.create({
  baseURL: process.env.BACKEND_URL || 'http://localhost:8080',
});

export default axiosClient;
