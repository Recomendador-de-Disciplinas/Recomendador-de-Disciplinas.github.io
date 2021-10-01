<template>
  <v-app>
    <Navbar />
    <router-view />
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar.vue';

export default {
  components: { Navbar },
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
