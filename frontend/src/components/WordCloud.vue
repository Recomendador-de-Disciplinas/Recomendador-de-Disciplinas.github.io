<template>
  <v-row class="transparent">
    <v-col class="border mx-2 d-flex flex-column rounded-lg" align="center">
      <h2 class="mb-4">Disciplinas cursadas</h2>
      <VueWordCloud
        class="mx-auto"
        style="height: 480px; width: 640px"
        :words="allWords"
        :color="
          ([, weight]) =>
            weight > 10 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'
        "
        font-family="Roboto"
      />
      <h2 class="mt-4">Disciplinas Recomendadas</h2>
      <VueWordCloud
        class="mx-auto"
        style="height: 480px; width: 640px"
        :words="allRecommendations"
        :color="
          ([, weight]) =>
            weight > 10 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'
        "
        font-family="Roboto"
      />
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
  computed: {
    allRecommendations() {
      const occurrences = new Map();
      this.recommendations.forEach((recommendation) => {
        const frequency = occurrences.get(recommendation);
        occurrences.set(recommendation, frequency ? frequency + 1 : 1);
      });
      return this.recommendations.map((recommendation) => [
        recommendation.split(' - ')[1].trim(),
        occurrences[recommendation],
      ]);
    },
    allWords() {
      const allDisciplines = [...this.disciplines].concat(this.recommendations);
      return allDisciplines.map((discipline) => [discipline, 1]);
    },
  },
};
</script>

<style></style>
