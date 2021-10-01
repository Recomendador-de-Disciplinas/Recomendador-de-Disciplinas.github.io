import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import Painel from '@/views/Painel.vue';
import Start from '@/views/Start.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/painel',
    name: 'Painel',
    component: Painel,
  },
  {
    path: '/start',
    name: 'Start',
    component: Start,
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

export default router;
