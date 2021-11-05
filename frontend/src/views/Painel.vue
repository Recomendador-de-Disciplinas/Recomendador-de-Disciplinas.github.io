<template>
  <v-container :class="containerClass">
    <v-container
      v-if="checkData"
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
            Topicos de interesse: {{ keywordsNames }}
          </p>
          <p class="mx-2 mb-0 text--secondary text-subtitle">
            Departamentos de interesse: {{ departmentInfos }}
          </p>
        </div>
      </v-row>
      <v-row><Tabs /></v-row>
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
    disciplines: '',
    departments: '',
    keywords: '',
  }),
  mounted() {
    this.name = JSON.parse(localStorage.getItem('name')) || '';
    this.disciplines = JSON.parse(localStorage.getItem('disciplines')) || [];
    this.departments = JSON.parse(localStorage.getItem('departments')) || [];
    this.keywords = JSON.parse(localStorage.getItem('keywords')) || [];
  },
  computed: {
    checkData() {
      return this.name == '';
    },
    containerClass() {
      let className = 'height-100';
      if (this.checkData) className += ' d-flex';
      return className;
    },
    keywordsNames() {
      return this.keywords.join(', ');
    },
    departmentInfos() {
      return this.departments.map((dep) => dep.code).join(', ');
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
