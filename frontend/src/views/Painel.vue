<template>
  <v-container :class="containerClass">
    <v-container v-if="checkData" class="d-flex flex-column align-self-center align-center">
        <h1 class="text-center">Preencha seus dados para visualizar o painel :)</h1>
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
        <h1 class="mx-2">{{ name }}</h1>
      </v-row>
      <v-row>
        <v-col class="border mx-2 d-flex flex-column rounded-lg">
          <h2 class="mb-4">Disciplinas cursadas</h2>
          <v-chip class="mb-2" v-for="(discipline, i) in disciplines" :key="i">
            {{ discipline }}
          </v-chip>
        </v-col>
        <v-col class="border mx-2 d-flex flex-column rounded-lg">
          <h2 class="mb-4">Departamentos desejados</h2>
          <v-chip class="mb-2" v-for="(department, i) in departments" :key="i">
            {{ department }}
          </v-chip>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    name: '',
    disciplines: '',
    departments: '',
  }),
  mounted() {
    this.name = JSON.parse(localStorage.getItem('name')) || '';
    this.disciplines = JSON.parse(localStorage.getItem('disciplines')) || [];
    this.departments = JSON.parse(localStorage.getItem('departments')) || [];
  },
  computed: {
    checkData() {
      return (
        this.name == '' ||
        this.disciplines.length == 0 ||
        this.departments.length == 0
      );
    },
    containerClass() {
      let className = 'height-100';
      if (this.checkData) className += " d-flex";
      return className;
    }
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
</style>
