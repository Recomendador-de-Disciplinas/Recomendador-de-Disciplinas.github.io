<template>
  <v-row class="transparent">
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
</template>

<script>
export default {
  data: () => ({
    disciplines: '',
    departments: '',
  }),
  mounted() {
    this.name = JSON.parse(localStorage.getItem('name')) || '';
    this.disciplines = JSON.parse(localStorage.getItem('disciplines')) || [];
    this.departments = JSON.parse(localStorage.getItem('departments')) || [];
  },
};
</script>

<style></style>
