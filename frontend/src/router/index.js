import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import Forms from '@/views/Forms.vue';
import Panel from '@/views/Panel.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/forms',
    name: 'Forms',
    component: Forms,
  },
  {
    path: '/panel',
    name: 'Panel',
    component: Panel,
  },
];

const router = new VueRouter({
  mode: 'hash',
  routes,
});

export default router;
