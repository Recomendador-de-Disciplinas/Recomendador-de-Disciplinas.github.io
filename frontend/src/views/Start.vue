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
        <v-text-field label="Nome" clearable />
        <v-text-field
          label="Disciplinas já cursadas"
          v-model="discipline"
          :rules="rules"
          persistent-hint
          hint="Formato: MAC0110"
          @keydown.enter="addDisciplines"
        />
      </v-col>
      <v-col>
        <Board :disciplines="disciplines" @erase="eraseDiscipline" />
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
import Board from '@/components/Board.vue';

export default {
  data: () => ({
    discipline: '',
    disciplines: [],
    rules: [
      (value) => {
        const regex = /\D{3}\d{4}/;
        return value.match(regex) || 'Formato inválido! Exemplo: MAC0110';
      },
    ],
  }),
  components: {
    Board,
  },
  methods: {
    eraseDiscipline(discipline) {
      this.disciplines = this.disciplines.filter(
        (element) => discipline != element
      );
    },
    addDisciplines() {
      const regex = /\D{3}\d{4}/;
      if (this.discipline.match(regex)) {
        this.disciplines.push(this.discipline);
        this.discipline = '';
      }
    },
  },
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
