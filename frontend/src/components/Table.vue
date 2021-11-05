<template>
  <v-row class="transparent">
    <v-col class="border mx-2 d-flex flex-column rounded-lg">
      <h2 class="mb-4">Disciplinas cursadas</h2>
      <v-chip class="mb-2" v-for="(discipline, i) in disciplines" :key="i">
        {{ discipline }}
      </v-chip>
    </v-col>
    <v-col class="border mx-2 d-flex flex-column rounded-lg">
      <h2 class="mb-4">Disciplinas Recomendadas</h2>
      <v-chip
        class="mb-2"
        v-for="(recommendation, i) in recommendations"
        :key="i"
      >
        {{ recommendation }}
      </v-chip>
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: {
    disciplines: {
      type: Array,
      required: true,
    },
    recommendations: {
      type: Array,
      required: true,
    },
  },
};
</script>
