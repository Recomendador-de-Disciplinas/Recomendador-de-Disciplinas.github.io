<template>
  <v-container class="graph-container align-center d-flex flex-column" fluid>
    <h2 class="my-5 text-center">
      Disciplinas recomendadas disponíveis para serem feitas
    </h2>

    <div class="light-border" id="graph"></div>
    <div
      class="
        mt-1
        d-flex
        flex-column
        justify-center
        align-center
        light-border
        legend-size
      "
    >
      <h2 class="text-center mt-3">Legenda</h2>
      <div class="my-5 d-flex">
        <span class="border rounded-circle pa-4 mx-2 approved-green"
          >Aprovada</span
        >
        <span class="border rounded-circle pa-4 mx-2 white">Disponível</span>
      </div>
    </div>
  </v-container>
</template>

<script>
import GraphGenerator from '@/plugins/graph';
export default {
  props: {
    possibleRecommendations: {
      type: Object,
      required: true,
    },
  },
  mounted() {
    const frame = document.getElementById('graph');
    GraphGenerator({
      data: this.possibleRecommendations,
      width: frame.clientWidth,
      height: frame.clientHeight,
      container: frame,
    });
  },
};
</script>

<style scoped>
.graph-container {
  height: 100vh;
}

#graph {
  width: 100%;
  height: 70%;
}

.light-border {
  border: 1px solid #6666;
}

.border {
  border: 1px solid black !important;
}

.legend-size {
  width: 30%;
}

.approved-green {
  background-color: #cee7cc;
}
</style>
