<template>
  <v-container>
    <v-alert v-for="error in errors" :key="error" type="error">{{
      error
    }}</v-alert>
    <v-form ref="form">
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
          <v-text-field label="Nome" v-model="name" required clearable />
          <v-autocomplete
            :items="disciplinesCodes"
            label="Disciplinas já cursadas"
            v-model="discipline"
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
          <v-combobox
            label="Tópicos de interesse"
            v-model="keywords"
            deletable-chips
            multiple
            small-chips
          ></v-combobox>
          <v-autocomplete
            label="Departamentos de interesse"
            v-model="departments"
            :items="departmentInfo"
            deletable-chips
            multiple
            small-chips
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-btn
          class="px-10 mt-8 py-7 rounded-lg"
          color="#CEE7CC"
          depressed
          @click="submit"
          >Salvar</v-btn
        >
      </v-row>
    </v-form>
  </v-container>
</template>

<script>
import Board from '@/components/Board.vue';
import Form from './forms';

export default {
  data: () => ({
    name: '',
    discipline: '',
    disciplines: [],
    departments: [],
    keywords: [],
    allDisciplines: [],
    allDepartments: [],
    errors: [],
  }),
  components: {
    Board,
  },
  mounted() {
    this.name = JSON.parse(localStorage.getItem('name')) || '';
    this.keywords = JSON.parse(localStorage.getItem('keywords')) || [];

    this.getSavedDisciplines();
    this.getSavedDepartments();

    this.getAllDisciplines();
    this.getAllDepartments();
  },
  methods: {
    getSavedDisciplines() {
      const disciplineObjects =
        JSON.parse(localStorage.getItem('disciplines')) || [];
      this.disciplines = disciplineObjects.map((disc) => disc.code);
    },
    getSavedDepartments() {
      const departmentObjects =
        JSON.parse(localStorage.getItem('departments')) || [];
      this.departments = departmentObjects.map(
        (dep) => `${dep.code} - ${dep.name}`
      );
    },
    eraseDiscipline(discipline) {
      this.disciplines = this.disciplines.filter(
        (element) => discipline != element
      );
    },
    addDiscipline() {
      const hasDiscipline = this.disciplines.find(
        (element) => element == this.discipline
      );
      if (!hasDiscipline) {
        const disciplineExists = this.disciplinesCodes.find(
          (element) => element == this.discipline
        );

        if (disciplineExists) {
          this.disciplines.push(this.discipline);
          this.discipline = '';
        }
      }
    },
    submit() {
      const errors = Form.saveClientSide(
        localStorage,
        {
          name: this.name,
          disciplines: this.disciplines,
          departments: this.departments,
          keywords: this.keywords,
        },
        this.allDepartments,
        this.allDisciplines
      );

      if (!errors || errors.length === 0) {
        this.$router.push('/painel');
        this.errors = [];
      } else {
        this.errors = errors;
      }
    },
    async getAllDisciplines() {
      const url = process.env.BACKEND_URL || 'http://localhost:8080';
      const response = await fetch(url + '/disciplines');
      this.allDisciplines = await response.json();
    },
    async getAllDepartments() {
      const url = process.env.BACKEND_URL || 'http://localhost:8080';
      const response = await fetch(url + '/departments');
      this.allDepartments = await response.json();
    },
  },
  computed: {
    disciplinesCodes() {
      return this.allDisciplines.map((element) => element.code);
    },
    departmentInfo() {
      return this.allDepartments.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
  },
  watch: {
    discipline() {
      this.addDiscipline();
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
