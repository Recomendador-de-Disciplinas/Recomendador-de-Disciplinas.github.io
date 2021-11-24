<template>
  <v-container>
    <v-form ref="form">
      <v-row>
        <v-col align="center">
          <h1 class="text-h5">Seja Bem Vindo(a)!</h1>
          <p class="subtitle">Forneça alguns dados inciais para começarmos</p>
        </v-col>
      </v-row>
      <v-row v-for="error in errors" :key="error">
        <v-col class="pa-0">
          <v-alert type="error">
            {{ error }}
          </v-alert>
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
          <v-text-field
            label="Nome"
            v-model="userData.name"
            required
            clearable
          />
          <v-autocomplete
            :items="backendData.allCoursesCode"
            label="Código do curso"
            v-model="userData.courseCode"
            no-data-text="Nenhum código de curso encontrado"
            hint="Exemplo: o código de Ciência da Computação no IME-USP é 45052. Caso não lembre o código do seu curso, acesse o JupiterWeb."
            persistent-hint
            clearable
          />
          <v-autocomplete
            :items="displayDisciplines"
            label="Disciplinas já
          cursadas"
            no-data-text="Nenhuma disciplina encontrada"
            v-model="discipline"
            clearable
            open-on-clear
            @change="addDiscipline"
          />
        </v-col>
        <v-col>
          <Board :disciplines="userData.disciplines" @erase="eraseDiscipline" />
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
            v-model="userData.keywords"
            deletable-chips
            multiple
            small-chips
          ></v-combobox>
          <v-autocomplete
            label="Departamentos de interesse"
            v-model="userData.departments"
            :items="displayDepartments"
            no-data-text="Nenhum departamento encontrado"
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
import {
  getComputedDataFromStorage,
  saveDataInStorage,
} from '@/services/Storage.js';
import { getAllFormDataFromBackend } from '@/services/Request.js';

export default {
  data: () => ({
    userData: {
      name: '',
      disciplines: [],
      departments: [],
      keywords: [],
      recommendations: [],
      courseCode: '',
    },
    backendData: {
      allCoursesCode: [],
      allDisciplines: [],
      allDepartments: [],
    },
    discipline: '',
    errors: [],
  }),
  components: {
    Board,
  },
  mounted() {
    this.userData = getComputedDataFromStorage(localStorage);
    this.fetchBackendData();
  },
  methods: {
    async fetchBackendData() {
      const allDisciplines =
        (await getAllFormDataFromBackend('/disciplines')) || [];
      const allDepartments =
        (await getAllFormDataFromBackend('/departments')) || [];
      const allCoursesCode =
        (await getAllFormDataFromBackend('/requisites/courses'))?.sort() || [];

      this.backendData = {
        allDisciplines,
        allDepartments,
        allCoursesCode,
      };
    },
    eraseDiscipline(discipline) {
      this.userData.disciplines = this.userData.disciplines.filter(
        (element) => discipline != element
      );
    },
    addDiscipline() {
      const hasDiscipline = this.userData.disciplines.find(
        (element) => element == this.discipline
      );
      if (!hasDiscipline) {
        const disciplineExists = this.displayDisciplines.find(
          (element) => element == this.discipline
        );

        if (disciplineExists) {
          this.userData.disciplines.push(this.discipline);
          this.discipline = '';
        }
      }
    },
    submit() {
      const errors = saveDataInStorage(localStorage, {
        userData: this.userData,
        backendData: this.backendData,
      });

      if (errors.length === 0) {
        this.$router.push('/panel');
      }
      this.errors = errors;
    },
  },
  computed: {
    displayDisciplines() {
      return this.backendData.allDisciplines.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
    displayDepartments() {
      return this.backendData.allDepartments.map(
        (element) => `${element.code} - ${element.name}`
      );
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
