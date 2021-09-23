<template>
  <v-container>
    <v-row>
      <Navbar />
    </v-row>
    <v-row>
      <h1>Painel</h1>
    </v-row>
  </v-container>
</template>

<script>
import Navbar from '@/components/Navbar.vue';

export default {
  name: 'Painel',
  components: { Navbar },
}
</script>