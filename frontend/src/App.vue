<template>
  <v-app>
    <Navbar :paths="paths" />
    <router-view />
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar.vue';

export default {
  components: { Navbar },
  data: () => ({
    paths: [
      { name: 'Home', url: '/' },
      { name: 'Dados', url: '/forms' },
      { name: 'Meu Painel', url: '/painel' },
    ],
  }),
};
</script>

<style>
:root {
  width: 100vw;
  height: 100vh;
}

#app {
  background-color: #eeede7;
}
</style>
