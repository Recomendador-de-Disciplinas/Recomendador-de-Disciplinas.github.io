<template>
  <v-row class="transparent">
    <v-col class="border mx-2 d-flex flex-column rounded-lg">
      <h2 class="mb-4">Disciplinas cursadas</h2>
      <v-chip class="mb-2" v-for="(discipline, i) in disciplinesCodes" :key="i">
        {{ discipline }}
      </v-chip>
    </v-col>
    <v-col class="border mx-2 d-flex flex-column rounded-lg">
      <h2 class="mb-4">Departamentos desejados</h2>
      <v-chip class="mb-2" v-for="(department, i) in departmentInfo" :key="i">
        {{ department }}
      </v-chip>
    </v-col>
    <v-col class="border mx-2 d-flex flex-column rounded-lg">
      <h2 class="mb-4">Disciplinas Recomendadas</h2>
      <v-chip
        class="mb-2"
        v-for="(recommendation, i) in recommendationsInfo"
        :key="i"
      >
        {{ recommendation }}
      </v-chip>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    disciplines: [],
    departments: [],
    recommendations: [],
  }),
  methods: {
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
      console.log(this.recommendations);
    },
  },
  mounted() {
    this.name = JSON.parse(localStorage.getItem('name')) || '';
    this.disciplines = JSON.parse(localStorage.getItem('disciplines')) || [];
    this.departments = JSON.parse(localStorage.getItem('departments')) || [];
    this.keywords = JSON.parse(localStorage.getItem('topics')) || [];
    this.getRecommendations();
  },
  computed: {
    disciplinesCodes() {
      return this.disciplines.map((element) => element.code);
    },
    departmentInfo() {
      return this.departments.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
    recommendationsInfo() {
      return this.recommendations.map(
        (element) => `${element.code} - ${element.name}`
      );
    },
  },
};
</script>

<style></style>
