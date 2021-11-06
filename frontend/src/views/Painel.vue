<template>
  <v-container :class="panelContainerClass">
    <v-container
      v-if="checkIfUserHasNotData"
      class="d-flex flex-column align-self-center align-center"
    >
      <h1 class="text-center">
        Preencha seus dados para visualizar o painel :)
      </h1>
      <v-btn
        class="mt-8 py-7 rounded-lg"
        color="#CEE7CC"
        depressed
        width="50%"
        to="/forms"
        >Preencher agora</v-btn
      >
    </v-container>
    <div v-else>
      <v-row class="my-4 flex flex-column">
        <h1 class="mx-2 mb-1 font-weight-regular text-h4">{{ name }}</h1>
        <div>
          <p class="mx-2 mb-0 text--secondary text-subtitle">
            Topicos de interesse: {{ displayKeywords }}
          </p>
          <p class="mx-2 mb-0 text--secondary text-subtitle">
            Departamentos de interesse: {{ displayDepartments }}
          </p>
        </div>
      </v-row>
      <v-row>
        <Tabs
          :disciplines="displayDisciplines"
          :recommendations="displayRecommendations"
        />
      </v-row>
    </div>
  </v-container>
</template>

<script>
import Tabs from '@/components/Tabs';
export default {
  components: {
    Tabs,
  },
  data: () => ({
    name: '',
    disciplines: [],
    departments: [],
    keywords: [],
    recommendations: [],
  }),
  mounted() {
    this.getDataFromStorage();
    if (!this.checkIfUserHasNotData) this.getRecommendations();
  },
  computed: {
    checkIfUserHasNotData() {
      return this.name == '';
    },
    panelContainerClass() {
      let className = 'height-100';
      if (this.checkIfUserHasNotData) className += ' d-flex';
      return className;
    },
    displayDisciplines() {
      return this.disciplines.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
    displayDepartments() {
      return this.departments.map((dep) => dep.code).join(', ');
    },
    displayKeywords() {
      return this.keywords.join(', ');
    },
    displayRecommendations() {
      return this.recommendations.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
  },
  methods: {
    getDataFromStorage() {
      this.name = JSON.parse(localStorage.getItem('name')) || '';
      this.disciplines = JSON.parse(localStorage.getItem('disciplines')) || [];
      this.departments = JSON.parse(localStorage.getItem('departments')) || [];
      this.keywords = JSON.parse(localStorage.getItem('keywords')) || [];
    },
    async getRecommendations() {
      const url = process.env.BACKEND_URL || 'http://localhost:8080';

      const headers = new Headers();
      headers.append('Content-Type', 'application/json');

      const body = await fetch(url + '/disciplines/recommendations', {
        headers,
        method: 'POST',
        body: JSON.stringify({
          departments: this.departments,
          keywords: this.keywords,
        }),
      });

      this.recommendations = await body.json();
    },
  },
};
</script>

<style scoped>
.height-100 {
  height: 100%;
}

.border {
  border: 1px solid black;
}

.color-grey {
  color: #868b8e;
}
</style>
