import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import Painel from '@/views/Painel.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/painel',
    name: 'Painel',
    component: Painel
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
