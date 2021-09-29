<template>
  <v-container>
    <v-row>
      <v-col align="center">
        <h1 class="text-h5">Seja Bem Vindo(a)!</h1>
        <p class="subtitle">Forneça alguns dados inciais para começarmos</p>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <h2 class="text-h6">Dados pessoais</h2>
        <v-divider class="divider"></v-divider>
      </v-col>
    </v-row>
    <v-row class="px-10">
      <v-col>
        <v-text-field label="Nome" clearable></v-text-field>
        <v-autocomplete
          label="Disciplinas já cursadas"
          :items="disciplines"
          clearable
        ></v-autocomplete>
      </v-col>
      <v-col>
        <!-- COLOCA O PAINEL AQUI GUERRERO -->
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <h2 class="text-h6">Interesses</h2>
        <v-divider class="divider"></v-divider>
      </v-col>
    </v-row>
    <v-row class="px-10">
      <v-col>
        <v-text-field label="Tópicos de interesse" clearable></v-text-field>
        <v-autocomplete
          label="Departamentos de interesse"
          :items="disciplines"
          clearable
        ></v-autocomplete>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-btn class="px-10 mt-8 py-7 rounded-lg" color="#CEE7CC" depressed
        >Ver disciplinas</v-btn
      >
    </v-row>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    disciplines: ['MAC0110', 'MAC0121'],
  }),
};
</script>

<style scoped>
.subtitle {
  color: #868b8e;
}

.divider {
  background-color: black;
}
</style>
