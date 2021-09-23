<template>
  <v-container class="main-container">
    <v-row>
      <Navbar />
    </v-row>

    <v-row
      align='center'
      class='main-row'
    >
      <v-col
        align-self='center'
        cols='4'
        class='usp-logo'
      >
        <img src="@/assets/usp-logo-transp.png" alt="Logo USP" class="logo-usp">
      </v-col>
      <v-col
        cols='8'
      >
        <div class="text">
          <h1>Recomendador de Disciplinas</h1>
          <v-divider></v-divider>
          <h2>Facilitando seu caminho</h2>
        </div>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import Navbar from '@/components/Navbar.vue'

export default {
  name: 'Home',
  components: { Navbar },
}
</script>

<style scoped>
.main-container {
  width: 100%;
  height: 100%;
}

.main-row {
  width: 100%;
  height: 100%;
}

.logo-usp {
  width: 187px;
  height: 77px;
}

.usp-logo {
  display: flex;
  justify-content: right;
}
</style>