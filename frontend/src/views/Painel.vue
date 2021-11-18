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
      <v-row class="my-4">
        <v-col>
          <h1 class="mx-2 mb-1 font-weight-regular text-h4">{{ name }}</h1>
          <div>
            <p class="mx-2 mb-0 text--secondary text-subtitle">
              Topicos de interesse: {{ displayKeywords }}
            </p>
            <p class="mx-2 mb-0 text--secondary text-subtitle">
              Departamentos de interesse: {{ displayDepartments }}
            </p>
          </div>
        </v-col>
        <v-col>
          <v-container
            class="d-flex flex-column justify-space-between align-end"
          >
            <v-btn
              class="my-1 px-5 py-2 small rounded-lg"
              color="#FAF7B1"
              depressed
              width="50%"
            >
              <v-icon left> mdi-pencil </v-icon>Editar Dados</v-btn
            >
            <v-btn
              class="my-1 px-5 py-2 small rounded-lg"
              color="#FAF7B1"
              depressed
              width="50%"
            >
              <v-icon left> mdi-pencil </v-icon>Editar Interesses</v-btn
            >
          </v-container>
        </v-col>
      </v-row>
      <v-row justify="center">
        <Tabs
          :disciplines="displayDisciplines"
          :recommendations="displayRecommendations"
          :possibleRecommendations="possibleRecommendations"
          v-if="dataFetched"
        />
        <v-progress-circular
          v-else
          :size="200"
          :width="20"
          color="blue"
          indeterminate
          >Loading</v-progress-circular
        >
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
    dataFetched: false,
    possibleRecommendations: {},
    courseCode: '',
  }),
  mounted() {
    this.getDataFromStorage();
    if (!this.checkIfUserHasNotData) {
      this.fetch();
    }
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
      this.courseCode = JSON.parse(localStorage.getItem('courseCode')) || '';
    },

    async fetchDataFromBackend(path, body) {
      const url = process.env.BACKEND_URL || 'http://localhost:8080';

      const headers = new Headers();
      headers.append('Content-Type', 'application/json');

      const response = await fetch(url + path, {
        headers,
        method: 'POST',
        body: JSON.stringify(body),
      });

      if (response.status === 200) {
        return await response.json();
      }
      return null;
    },
    async getRecommendations() {
      const body = {
        departmentsId: this.departments.map((department) => department.id),
        keywords: this.keywords,
      };
      this.recommendations = await this.fetchDataFromBackend(
        '/disciplines/recommendations',
        body
      );
    },
    async getPossibleRecommendationsForNextSemester() {
      const body = {
        departmentsId: this.departments.map((department) => department.id),
        disciplinesCode: this.disciplines.map((discipline) => discipline.code),
        keywords: this.keywords,
        courseCode: this.courseCode,
      };
      const response = await this.fetchDataFromBackend(
        '/disciplines/possible-recommendations',
        body
      );
      this.possibleRecommendations = this.processGraphData(response);
    },
    async fetch() {
      this.dataFetched = false;
      await this.getRecommendations();
      await this.getPossibleRecommendationsForNextSemester();
      this.dataFetched = true;
    },
    processGraphData(rawData) {
      const disciplinesIdInNodesList = new Map();
      const data = {
        nodes: [],
        links: [],
      };

      rawData.forEach((discipline) => {
        const { code, name, url } = discipline;
        const requisitesByCourse = discipline.requisites;
        const requisites = requisitesByCourse[0]?.requisites;
        let idInNodeList = data.nodes.length + 1;

        data.nodes.push({
          id: idInNodeList,
          name: `${code} - ${name}`,
          code,
          url,
        });

        requisites?.forEach((requisite) => {
          const discipline = requisite.discipline;
          const [code, _] = discipline.split('-').map((el) => el.trim());
          let requisiteIdInNodeList;

          if (!disciplinesIdInNodesList.has(code)) {
            requisiteIdInNodeList = data.nodes.length + 1;
            disciplinesIdInNodesList.set(code, requisiteIdInNodeList);

            data.nodes.push({
              id: requisiteIdInNodeList,
              name: discipline,
              code,
              url: null,
            });
          } else {
            requisiteIdInNodeList = disciplinesIdInNodesList.get(code);
          }

          data.links.push({
            source: requisiteIdInNodeList,
            target: idInNodeList,
          });
        });
      });
      return data;
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
